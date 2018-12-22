package modelchecking;

import cesk.State;
import cesk.SymbolTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    Stack<ModelState> dfs1_stack = new Stack<>();
    Stack<ModelState> dfs2_stack = new Stack<>();
    public boolean found_example = false;
    public List<SymbolTable> example = new ArrayList<>();

    public void dfs1(ModelState ms) {
        dfs1_stack.push(ms);

        List<ModelState> lst_ms = ms.next_prob();
        for (ModelState ms_succ : lst_ms) {

//            System.out.println("in dfs1");
//            System.out.println(ms_succ.program_state.environment);
//            System.out.println("property state: " + ms_succ.prop_state.id);
//            System.out.println("program counter: " + ms_succ.program_state.pc);

            if (!dfs1_stack.contains(ms_succ) && !found_example) {
                dfs1(ms_succ);
            }
            else {
//                System.out.println("Detect loop in dsf1\n");
            }

            if (found_example) {
                example.add(ms.program_state.environment);
                return;
            }
        }

//        System.out.println("Finished exploring a branch in dsf1\n");

        if (ms.is_accept() && !found_example) {
            dfs2(ms);
        }
    }

    public void dfs2(ModelState ms) {
//        ms.dfs2 = true;
        dfs2_stack.push(ms);
        // TODO: the .next() function does not work for dfs2
        List<ModelState> lst_ms = ms.next_prob();

        for (ModelState ms_succ : lst_ms) {

//            System.out.println("in dfs2");
//            System.out.println(ms_succ.program_state.environment);
//            System.out.println("property state: " + ms_succ.prop_state.id);
//            System.out.println("program counter: " + ms_succ.program_state.pc);

            if (dfs1_stack.contains(ms_succ)) {
                System.out.println("satisfied state: " + ms_succ.program_state.environment);
                found_example = true;
                return;
            }
            else if (!dfs2_stack.contains(ms_succ)) {
                dfs2(ms_succ);
            }
        }
    }
}
