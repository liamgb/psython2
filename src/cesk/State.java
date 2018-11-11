package cesk;

import ast.expression.Expression;
import ast.expression.ExpressionList;
import ast.expression.FunctionCallExp;
import ast.expression.FunctionExp;
import ast.leaf.Argument;

import java.util.List;
import java.util.Stack;


public class State implements Cloneable{
    public int control_counter = -1;
    public ExpressionList current_frame = null;
    public SymbolTable environment = null;
    public String scope = null;
    public Stack<State> frame_stack = new Stack<>();

    public State(SymbolTable env, ExpressionList explist) {
        this.current_frame = explist;
        this.environment = env;
    }

    public Expression next() {
        //TODO: pretty sure it's not finished, to be cont.
        control_counter += 1;

        // itr through current frame
        if (control_counter < current_frame.exp_list.size()) {
            return current_frame.exp_list.get(control_counter);
        }
        // hit the end of program, return null
        else {
            return null;
        }
    }

    public void interrupt(FunctionCallExp func_call, String func_name, List<Argument> arg_list) {
        try {
            frame_stack.push(this.clone(func_name));
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        FunctionExp func_def = (FunctionExp) this.environment.lookup(null, func_name).var;

        // init frame local variables
        for (int i = 0; i < arg_list.size(); i++) {
            String arg_name = func_def.func_args.get(i).id_name;
            Val arg_v = func_call.arg_list.get(i).eval(this);
            this.environment.lookup(null, func_name).anatomy.get(arg_name).v = arg_v;
        }

        this.control_counter = -1;
        this.current_frame = func_def.func_body;
        this.scope = func_name;
    }

    public void kont() {
        // hit the end of frame, cont. to next frame
        State tar_state = frame_stack.pop();
        this.control_counter = tar_state.control_counter;
        this.current_frame = tar_state.current_frame;
        this.environment = tar_state.environment;
        this.scope = tar_state.scope;
    }

    public State clone(String scope) throws CloneNotSupportedException
    {
        State c_state = (State) super.clone();
        c_state.environment = environment.clone(scope);
        return c_state;
    }
}
