package ast.wrapper;

import cesk.State;
import cesk.Val;


// everything except expression list
public interface Evaluable {
    public Val eval(State st);
}
