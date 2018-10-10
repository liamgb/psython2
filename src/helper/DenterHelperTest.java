package helper;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.junit.Test;
//import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static helper.DenterHelperTest.TokenType.EOF_TOKEN;
import static helper.DenterHelperTest.TokenType.INDENT;
import static helper.DenterHelperTest.TokenType.NL;
import static helper.DenterHelperTest.TokenType.NORMAL;
import static helper.DenterHelperTest.TokenType.DEDENT;
import static org.junit.Assert.assertEquals;
//import static org.testng.AssertJUnit.assertEquals;

public final class DenterHelperTest {
    public enum TokenType {
        NL, INDENT, DEDENT, NORMAL, EOF_TOKEN
    }

    @Test
    public void simple() {
        TokenChecker
                .of("hello")
                .nl("  bar")
                .raw(NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, NL, DEDENT, EOF_TOKEN);
    }

    @Test
    public void simpleWithNLs() {
        TokenChecker
                .of("hello")
                .nl("world")
                .nl("  tab1")
                .nl("  tab2")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, NL, NORMAL, INDENT, NORMAL, NL, NORMAL, NL, DEDENT, EOF_TOKEN);
    }

    @Test
    public void multipleDedents() {
        TokenChecker
                .of("hello")
                .nl("  line2")
                .nl("    line3")
                .nl("world")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, INDENT, NORMAL, NL, DEDENT, DEDENT, NORMAL, NL, EOF_TOKEN);
    }

    @Test
    public void multipleDedentsToEof() {
        TokenChecker
                .of("hello")
                .nl("  line2")
                .nl("    line3")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, INDENT, NORMAL, NL, DEDENT, DEDENT, EOF_TOKEN);
    }

    @Test
    public void ignoreBlankLines() {
        TokenChecker
                .of("hello")
                .nl("     ")
                .nl("")
                .nl("  dolly")
                .nl("        ")
                .nl("    ")
                .nl("")
                .nl("world")
                .raw(NORMAL, NL, NL, NL, NORMAL, NL, NL, NL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, NL, DEDENT, NORMAL, NL, EOF_TOKEN);
    }

    @Test
    public void allIndented() {
        TokenChecker
                .of("    hello")
                .nl("    line2")
                .nl("       line3")
                .nl("    ")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, NL, EOF_TOKEN)
                .dented(INDENT, NORMAL, NL, NORMAL, INDENT, NORMAL, NL, DEDENT, DEDENT, EOF_TOKEN);
    }

    @Test
    public void startIndentedThenEmptyLines() {
        TokenChecker
                .of("    hello")
                .nl("    line2")
                .nl("")
                .raw(NORMAL, NL, NORMAL, NL, EOF_TOKEN)
                .dented(INDENT, NORMAL, NL, NORMAL, NL, DEDENT, EOF_TOKEN);
    }

    @Test
    public void dedentToNegative() {
        // this shouldn't explode, it should just result in an extra dedent
        TokenChecker
                .of("    hello")
                .nl("    world")
                .nl("boom")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(INDENT, NORMAL, NL, NORMAL, NL, DEDENT, NORMAL, NL, EOF_TOKEN);
    }

    @Test
    public void halfDent() {
        TokenChecker
                .of("hello")
                .nl("     world")
                .nl("  boom")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, NL, DEDENT, INDENT, NORMAL, NL, DEDENT, EOF_TOKEN);
    }

    @Test
    public void halfDentFromTwo() {
        TokenChecker
                .of("hello")
                .nl("     world")
                .nl("         universe")
                .nl("  boom")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, INDENT, NORMAL, NL, DEDENT, DEDENT, INDENT, NORMAL, NL, DEDENT, EOF_TOKEN);
    }

    @Test
    public void withReturn() {
        TokenChecker
                .of("hello")
                .nl("world")
                .rf("dolly")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, NL, NORMAL, NL, NORMAL, NL, EOF_TOKEN);
    }

    @Test
    public void ignoreEofNoDedent() {
        TokenChecker
                .of("hello")
                .raw(NORMAL, EOF_TOKEN)
                .ignoreEof()
                .dented(NORMAL, EOF_TOKEN);
    }

    @Test
    public void ignoreEofWithDedent() {
        TokenChecker
                .of("hello")
                .nl("  world")
                .raw(NORMAL, NL, NORMAL, EOF_TOKEN)
                .ignoreEof()
                .dented(NORMAL, INDENT, NORMAL, EOF_TOKEN);
    }

    @Test
    public void tabIndents() {
        TokenChecker
                .of("{")
                .nl("\t\tline1")
                .nl("\t\tline2")
                .nl("}")
                .raw(NORMAL, NL, NORMAL, NL, NORMAL, NL, NORMAL, EOF_TOKEN)
                .dented(NORMAL, INDENT, NORMAL, NL, NORMAL, NL, DEDENT, NORMAL, NL, EOF_TOKEN);
    }

    private interface TokenBuilder {
        TokenBuilder nl(String line);
        TokenBuilder rf(String line);
        DentChecker raw(TokenType... expected);
    }

    private interface DentChecker {
        DentChecker ignoreEof();
        void dented(TokenType... expected);
    }

    private static class TokenChecker implements TokenBuilder, DentChecker {
        private int lineNo;
        private final List<Token> tokens = new ArrayList<>();
        private boolean ignoreEof = false;

        private TokenChecker() {}

        public static TokenChecker of(String firstLine) {
            TokenChecker tb = new TokenChecker();
            LineBuilder lineBuilder = new LineBuilder(0, tb.tokens);
            int leading = leadingSpacesOf(firstLine);
            lineBuilder.pos = leading;
            firstLine = firstLine.substring(leading);
            if (!firstLine.isEmpty()) {
                lineBuilder.addToken("", firstLine, NORMAL);
            }
            return tb;
        }

        @Override
        public TokenBuilder nl(String line) {
            tokenize("\n", line);
            return this;
        }

        @Override
        public TokenBuilder rf(String line) {
            tokenize("\r\n", line);
            return this;
        }

        @Override
        public DentChecker ignoreEof() {
            ignoreEof = true;
            return this;
        }

        @Override
        public void dented(TokenType... expected) {
            List<Token> dented = dent(tokens);
            List<TokenType> dentedTypes = tokensToTypes(dented);
            assertEquals("dented tokens", Arrays.asList(expected), dentedTypes);
        }

        private List<TokenType> tokensToTypes(List<Token> tokens) {
            List<TokenType> types = new ArrayList<>();
            for (Token t : tokens) {
                int type = t.getType();
                TokenType tokenType = type == Token.EOF
                        ? EOF_TOKEN
                        : TokenType.values()[type];
                types.add(tokenType);
            }
            return Collections.unmodifiableList(types);
        }

        private void tokenize(String nlChars, String line) {
            LineBuilder lineBuilder = new LineBuilder(++lineNo, tokens);
            int leading = leadingSpacesOf(line);
            lineBuilder.addToken(nlChars, line.substring(0, leading), NL);
            line = line.substring(leading);
            if (!line.isEmpty()) {
                lineBuilder.addToken("", line, NORMAL);
            }
        }

        private List<Token> dent(List<Token> tokens) {
            final Iterator<Token> tokenIter = tokens.iterator();
            DenterHelper denter = new IterableBasedDenterHelper(NL.ordinal(), INDENT.ordinal(), DEDENT.ordinal(), tokenIter);
            if (ignoreEof) {
                denter.getOptions().ignoreEOF();
            }
            List<Token> dented = new ArrayList<>();
            while(true) {
                Token token = denter.nextToken();
                dented.add(token);
                if (token.getType() == Token.EOF) {
                    return Collections.unmodifiableList(dented);
                }
            }
        }

        @Override
        public DentChecker raw(TokenType... expected) {
            tokens.add(new CommonToken(Token.EOF, "<eof-token>"));
            List<TokenType> rawTypes = tokensToTypes(tokens);
            assertEquals("raw tokens", Arrays.asList(expected), rawTypes);
            return this;
        }

        private static class LineBuilder {
            private final int lineNo;
            private int pos = 0;
            private final List<Token> builder;

            private LineBuilder(int lineNo, List<Token> builder) {
                this.lineNo = lineNo;
                this.builder = builder;
            }

            private void addToken(String prefix, String s, TokenType tokenType) {
                CommonToken token = new CommonToken(tokenType.ordinal(), prefix + s);
                token.setCharPositionInLine(pos);
                token.setLine(lineNo);
                pos += s.length();
                builder.add(token);
            }
        }
    }

    private static int leadingSpacesOf(String s) {
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return i;
            }
        }
        // no spaces in the string (including blank string)
        return s.length();
    }

    private static class IterableBasedDenterHelper extends DenterHelper {
        private final Iterator<Token> tokens;

        private IterableBasedDenterHelper(int nlToken, int indentToken, int dedentToken, Iterator<Token> tokens) {
            super(nlToken, indentToken, dedentToken);
            this.tokens = tokens;
        }

        @Override
        protected Token pullToken() {
            return tokens.next();
        }
    }

}