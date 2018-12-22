package modelchecking;

import ast.atomic.RandAssign;
import ast.expression.NextRandExp;
import cesk.State;
import cesk.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModelState {
    public final PropertyAutomaton property_a = PropertyAutomaton.get_singleton();
    public PropertyState prop_state = property_a.p0;
    public State program_state;
    boolean dfs2 = false;

    public ModelState(State program_state){
        this.program_state = program_state;
    }

    public ModelState(State program_state, PropertyState prop_state){
        this.program_state = program_state;
        this.prop_state = prop_state;
    }

    private void update_program() {
        program_state = program_state.next();
    }

    private List<State> get_next_prog_state() throws CloneNotSupportedException{
        return program_state.next_nd_coverage();
    }

    public boolean is_accept() {
        return this.prop_state.accept;
    }

    public List<ModelState> next_prob() {
        try {
            List<ModelState> new_states = new ArrayList<>();

            for (Transition t : property_a.graph.get(prop_state)) {
                if (t.condition.eval(program_state) != null){
                    if (t.condition.eval(program_state).bool_v) {
                        ModelState new_state = new ModelState(
                                program_state.snapshot(), this.prop_state.snapshot());
                        new_state.prop_state = t.to_state;

                        List<State> states = new_state.get_next_prog_state();
                        for (State ss : states) {
                            new_states.add(new ModelState(ss, new_state.prop_state));
                        }
                    }
                }
                else {
                    ModelState new_state = new ModelState(
                            program_state.snapshot(), this.prop_state.snapshot());

                    List<State> states = new_state.get_next_prog_state();
                    for (State ss : states) {
                        new_states.add(new ModelState(ss, new_state.prop_state));
                    }
                    new_states.add(new ModelState(
                            program_state.snapshot(), this.prop_state.snapshot()));
                }
            }
            return new_states;

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            assert false;
        }
        return null;
    }

    public List<ModelState> next() {
        try {
            List<ModelState> new_states = new ArrayList<>();

            for (Transition t : property_a.graph.get(prop_state)) {
                if (t.condition.eval(program_state).bool_v) {
                    ModelState new_state = new ModelState(
                            program_state.snapshot(), this.prop_state.snapshot());

                    new_state.prop_state = t.to_state;
                    new_state.update_program();
                    new_states.add(new_state);
                }
            }
            return new_states;

        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            assert false;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelState)) return false;
        ModelState that = (ModelState) o;
        return Objects.equals(prop_state, that.prop_state) &&
                Objects.equals(program_state, that.program_state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(property_a, prop_state, program_state, dfs2);
    }
}
