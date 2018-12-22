package cesk;


import ast.atomic.AtomicExe;
import ast.atomic.ImperativeProg;
import ast.atomic.RandAssign;
import ast.expression.*;
import ast.wrapper.Argument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;


public class State implements Cloneable{
//    public final boolean model_check;
    public final ImperativeProg imperative_prog = ImperativeProg.get_singleton();
    public int pc = -1;
    public SymbolTable environment = null;
    public String scope = null;
    public Stack<State> frame_stack = new Stack<>();
    public Val return_val = null;
    public boolean terminated = false;


    public State(SymbolTable env) {
//        this.model_check = model_check;
        this.environment = env;
    }

    public State next() {
        pc++;
        if (pc >= 0 && pc < imperative_prog.size()) {
            imperative_prog.get(pc).step(this);
            return this;
        }
        else {
            pc--;
            terminated = true;
            return this;
        }
    }

    public List<State> next_nd_coverage() throws CloneNotSupportedException{
        pc++;
        List<State> result = new ArrayList<State>();

        if (pc >= 0 && pc < imperative_prog.size()) {
            AtomicExe ae = imperative_prog.get(pc);
            if (ae instanceof RandAssign) {
                RandAssign ra = (RandAssign) ae;
                int trial = NextRandExp.rand_bound;

                for (int i = 0; i < trial; i++) {
                    State new_state = this.snapshot();
                    ra.step(new_state, i);
                    result.add(new_state);
                }

            } else {
                ae.step(this);
                result.add(this);
            }
        }
        else {
            result.add(this);
            terminated = true;
            pc--;
        }

        return result;
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

        this.pc = imperative_prog.indexOf(func_name);
        this.scope = func_name;
    }

    public void kont() {
        // hit the end of frame, cont. to next frame
        State tar_state = frame_stack.pop();
        this.pc = tar_state.pc - 1; // repeat the assignment again with new return value
        this.environment = tar_state.environment;
        this.scope = tar_state.scope;
    }

    // make a deep copy for recursive function
    public State clone(String scope) throws CloneNotSupportedException
    {
        State c_state = (State) super.clone();
        c_state.environment = environment.clone(scope);
        return c_state;
    }

    // make a deep copy of itself for model checking
    public State snapshot() throws CloneNotSupportedException
    {
        State c_state = (State) super.clone();

        c_state.environment = this.environment.clone();
        c_state.scope = this.scope;
        c_state.frame_stack = new Stack<>();
        if (this.return_val != null) {
            c_state.return_val = this.return_val.clone();
        }
        else {
            c_state.return_val = null;
        }

        for (State s : this.frame_stack) {
            c_state.frame_stack.push(s);
        }

        return c_state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;

        return pc == state.pc &&
                return_val == state.return_val &&
                Objects.equals(environment, state.environment) &&
                Objects.equals(scope, state.scope) &&
                Objects.equals(frame_stack, state.frame_stack);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pc, environment, scope, frame_stack, return_val);
    }
}
