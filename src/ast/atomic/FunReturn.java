package ast.atomic;

import ast.component.ReturnCmp;
import ast.expression.FunctionExp;
import cesk.State;
import cesk.Val;

public class FunReturn implements AtomicExe{
    ReturnCmp rc;

    public FunReturn(ReturnCmp rc) {
        this.rc = rc;
    }

    @Override
    public void step(State state) {
        FunctionExp func_def = (FunctionExp) state.environment.lookup(null, state.scope).var;
        Val result = func_def.ret_cmp.eval(state);

        // pop old frame and cont.
        state.kont();
        state.return_val = result;
    }
}
