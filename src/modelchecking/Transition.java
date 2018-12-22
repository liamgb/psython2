package modelchecking;

import ast.wrapper.TruthValueHolder;

public class Transition {
    public TruthValueHolder condition = null;
    public PropertyState to_state = null;

    public Transition(TruthValueHolder condition, PropertyState to_state) {
        this.to_state = to_state;
        this.condition = condition;
    }
}
