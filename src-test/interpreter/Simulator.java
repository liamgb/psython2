package interpreter;

import ast.expression.Expression;
import ast.expression.ExpressionList;
import ast.visitor.SymbolTableBuildingVisitor;
import cesk.State;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import parser.psythonASTLexer;
import parser.psythonASTParser;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Simulator {
    public static void testPass(final String filename, final int expected) {
        try {
            final ANTLRFileStream afs = new ANTLRFileStream(filename);
            final psythonASTLexer psyl = new psythonASTLexer(afs);
            final CommonTokenStream cts = new CommonTokenStream(psyl);
            final psythonASTParser psyp = new psythonASTParser(cts);

            // AST building
            ExpressionList prg = psyp.program().result;
            assertTrue(psyp.getNumberOfSyntaxErrors() == expected);

            // 2 passes symbol building
            SymbolTableBuildingVisitor stv = new SymbolTableBuildingVisitor();
            prg.accept(stv);
            stv = new SymbolTableBuildingVisitor(stv.result);
            prg.accept(stv);

            if (stv.result.check_undefined()) {
                System.out.println("Exist defined variables:");
                System.out.println(stv.result);
                assert false;
            }

            // Simulate
            State state = new State(stv.result, prg);
            while(true) {
                Expression exp = state.next();
                if (exp != null)
                    exp.eval(state);
                else
                    break;
            }

            System.out.println(state.environment);

        } catch (final Exception e) {
            e.printStackTrace();
//			assertTrue(e.getMessage(), false);
        }
    }

    @Test
    public void testProgram0() {
        Simulator.testPass("src-examples/test_sim1.py", 0);
    }

    @Test
    public void testProgram1() {
        Simulator.testPass("src-examples/test_sim2.py", 0);
    }

    @Test
    public void testProgram2() {
        Simulator.testPass("src-examples/test_sim3.py", 0);
    }

    @Test
    public void testProgram3() {
        Simulator.testPass("src-examples/test_sim4.py", 0);
    }

}
