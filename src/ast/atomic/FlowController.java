package ast.atomic;

import ast.wrapper.TruthValueHolder;
import cesk.State;

public class FlowController implements AtomicExe{
    public TruthValueHolder tvh;
    public int goto_counter = -1;
    public FlowType fc;
    public boolean flip;

    public FlowController(TruthValueHolder tvh, FlowType fc, boolean flip) {
        this.tvh = tvh;
        this.fc = fc;
        this.flip = flip;
    }

    @Override
    public void step(State state) {
        boolean truth = tvh.eval(state).bool_v;
        if ((truth || flip) && !(truth && flip)) {
            // state pc++
        }
        else {
            // state pc go to goto_counter
            state.pc = goto_counter;
        }
    }
}
