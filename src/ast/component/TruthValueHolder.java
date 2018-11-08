package ast.component;

/*
truth_val
    :	ID
    |	BOOL
    | 	relational
    |	logical
    ;
*/

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

public interface TruthValueHolder {
    public abstract void accept(PsythonVisitor v);
    public Val eval(State st);
}
