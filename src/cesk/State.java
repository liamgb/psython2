package cesk;

import ast.expression.Expression;
import ast.expression.ExpressionList;

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
        // hit the end of frame, cont. to next frame
        else if (frame_stack.size() > 0) {
            State k = frame_stack.pop();
            this.kont(k);
            control_counter += 1;

            return current_frame.exp_list.get(control_counter);
        }
        // hit the end of program, return null
        else {
            return null;
        }
    }

    public void interrupt(String func_name) {
        try {
            frame_stack.push(this.clone());
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        this.scope = func_name;
        SymbolTable new_env = this.environment;
        ExpressionList current_frame = null;
    }

    public void kont(State tar_state) {
        this.control_counter = tar_state.control_counter;
        this.current_frame = tar_state.current_frame;
        this.environment = tar_state.environment;
        this.scope = tar_state.scope;
    }

    public Object get_value() {
        return this;
    }

    public State clone() throws CloneNotSupportedException
    {
        return (State) super.clone();
    }
}
