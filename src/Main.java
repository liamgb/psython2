
import cesk.State;
import cesk.SymbolTable;
import modelchecking.DFS;
import modelchecking.ModelState;
import utility.Builder;

public class Main {
    public static void main(String[] args) {
        // Simulate
        State state = Builder.preprocessor(args[0], 0, false);
        ModelState m_state = new ModelState(state);

        DFS dfs = new DFS();
        dfs.dfs1(m_state);

        System.out.println("Found Satisfied example: " + dfs.found_example);
        System.out.println("Trace: ");
        for (SymbolTable st : dfs.example) {
            System.out.println(st);
        }
    }
}
