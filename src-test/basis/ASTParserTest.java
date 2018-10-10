package basis;

import ast.expression.ExpressionList;
import ast.visitor.PrettyPrintVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import parser.psythonASTLexer;
import parser.psythonASTParser;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ASTParserTest {

    public static void testPass(final String filename, final int expected) {
        try {
            final ANTLRFileStream afs = new ANTLRFileStream(filename);
            final psythonASTLexer psyl = new psythonASTLexer(afs);
            final CommonTokenStream cts = new CommonTokenStream(psyl);
            final psythonASTParser psyp = new psythonASTParser(cts);

            ExpressionList prg = psyp.program().result;
            assertTrue(psyp.getNumberOfSyntaxErrors() == expected);

            PrettyPrintVisitor pv = new PrettyPrintVisitor();
            prg.accept(pv);
            System.out.println(pv.result);
        } catch (final Exception e) {
            e.printStackTrace();
//			assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void testProgram0() {
        ASTParserTest.testPass("src-examples/test_while.py", 0);
    }

    @Test
    public void testProgram1() {
        ASTParserTest.testPass("src-examples/test_ifthenelse.py", 0);
    }

    @Test
    public void testProgram2() {
        ASTParserTest.testPass("src-examples/test_func.py", 0);
    }

    @Test
    public void testProgram3() {
        ASTParserTest.testPass("src-examples/test_opts.py", 0);
    }

    @Test
    public void testProgram8() {
        ASTParserTest.testPass("src-examples/xample.py", 0);
    }

}
