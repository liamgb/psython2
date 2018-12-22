package ast.atomic;

import ast.wrapper.TruthValueHolder;
import cesk.State;

public class FuncDef implements AtomicExe{
    public String name;
    public int start_position = -1;
    public int end_position = -1;

    public FuncDef(String name, int start_position) {
        this.name = name;
        this.start_position = start_position;
    }

    @Override
    public void step(State state) {
        state.pc = end_position;
    }
}
