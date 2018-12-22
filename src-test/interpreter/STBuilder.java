package interpreter;

import ast.expression.ExpressionList;
import ast.visitor.SymbolTableVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import parser.psythonASTLexer;
import parser.psythonASTParser;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class STBuilder {

    public static void testPass(final String filename, final int expected) {
        try {
            final ANTLRFileStream afs = new ANTLRFileStream(filename);
            final psythonASTLexer psyl = new psythonASTLexer(afs);
            final CommonTokenStream cts = new CommonTokenStream(psyl);
            final psythonASTParser psyp = new psythonASTParser(cts);

            ExpressionList prg = psyp.program().result;
            assertTrue(psyp.getNumberOfSyntaxErrors() == expected);

            SymbolTableVisitor stv = new SymbolTableVisitor();
            prg.accept(stv);
            stv = new SymbolTableVisitor(stv.result);
            prg.accept(stv);

            System.out.println(stv.result);

        } catch (final Exception e) {
            e.printStackTrace();
//			assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void testProgram0() {
        STBuilder.testPass("src-examples/test1.py", 0);
    }

    @Test
    public void testProgram1() {
        STBuilder.testPass("src-examples/test2.py", 0);
    }

    @Test
    public void testProgram2() {
        STBuilder.testPass("src-examples/test_func.py", 0);
    }

    @Test
    public void testProgram3() {
        STBuilder.testPass("src-examples/test_opts.py", 0);
    }

    @Test
    public void testProgram8() {
        STBuilder.testPass("src-examples/xample.py", 0);
    }

}
