package modelchecker;

import ast.expression.Expression;
import ast.expression.ExpressionList;
import ast.expression.NextRandExp;
import ast.visitor.NumberingVisitor;
import ast.visitor.SymbolTableVisitor;
import cesk.State;
import cesk.SymbolTable;
import modelchecking.DFS;
import modelchecking.ModelState;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import parser.psythonASTLexer;
import parser.psythonASTParser;
import utility.Builder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularChecker {
    public static void testPass(final String filename, final int expected) {
        // Simulate
        State state = Builder.preprocessor(filename, expected, false);
        ModelState m_state = new ModelState(state);

        DFS dfs = new DFS();
        dfs.dfs1(m_state);

        System.out.println("Found Satisfied example: " + dfs.found_example);
        System.out.println("Trace: ");
        for (SymbolTable st : dfs.example) {
            System.out.println(st);
        }
    }

    @Test
    public void testProgram0() {
        modelchecker.RegularChecker.testPass("src-examples/test_mc_while.py", 0);
    }

    @Test
    public void testProgram1() {
        modelchecker.RegularChecker.testPass("src-examples/test_mc_while_rand.py", 0);
    }

    @Test
    public void testProgram2() {modelchecker.RegularChecker.testPass("src-examples/test_puzzle.py", 0);}
}
