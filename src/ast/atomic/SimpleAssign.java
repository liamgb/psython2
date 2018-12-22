package ast.atomic;

import ast.expression.AssignmentExp;
import cesk.State;

public class SimpleAssign implements AtomicExe{
    public AssignmentExp assign_node;

    public SimpleAssign(AssignmentExp ae) {
        assign_node = ae;
    }

    @Override
    public void step(State state) {
        assign_node.eval(state);
    }
}
