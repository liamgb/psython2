package interpreter;

import ast.expression.Expression;
import cesk.State;
import org.junit.jupiter.api.Test;
import utility.Builder;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Simulator {
    public static void testPass(final String filename, final int expected) {
        // Simulate
        State state = Builder.preprocessor(filename, expected, true);
        while(true) {
            State st = state.next();
            if (st.terminated)
                break;
        }

        System.out.println(state.environment);
    }

//    @Test
//    public void testProgram_1() {
//        Simulator.testPass("src-examples/test_mc_while.py", 0);
//    }

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

    @Test
    public void testProgram4() {
        Simulator.testPass("src-examples/test_mc_while_rand.py", 0);
    }

    @Test
    public void testProgram5() {
        Simulator.testPass("src-examples/test_puzzle.py", 0);
    }

}
