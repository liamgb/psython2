package ast.atomic;

import ast.expression.AssignmentExp;
import ast.expression.FunctionCallExp;
import cesk.State;
import cesk.Val;

public class FuncAssign implements AtomicExe{
    FunctionCallExp fc;
    AssignmentExp ae;

    public FuncAssign(AssignmentExp ae) {
        this.ae = ae;
        this.fc = (FunctionCallExp) ae.rhs;
    }

    @Override
    public void step(State state) {
        if (state.return_val == null) {
            state.interrupt(fc, fc.get_name(), fc.arg_list);
        } else {
            Val res = state.return_val;
            ae.lhs.lookup(state).v = res;
            state.return_val = null;
        }
    }
}
