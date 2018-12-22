package ast.atomic;

import ast.expression.AssignmentExp;
import cesk.State;
import cesk.Val;

public class RandAssign implements AtomicExe{
    public AssignmentExp assign_node;

    public RandAssign(AssignmentExp ae) {
        assign_node = ae;
    }

    public void step(State state, int assign_val) {
        Val res = new Val(assign_val);
        assign_node.lhs.lookup(state).v = res;
    }

    @Override
    public void step(State state) {
        assign_node.eval(state);
    }
}
