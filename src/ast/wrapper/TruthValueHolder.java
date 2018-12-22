package ast.wrapper;

/*
truth_val
    :	ID
    |	BOOL
    | 	relational
    |	logical
    ;
*/

import ast.wrapper.Evaluable;
import ast.visitor.PsythonVisitor;

public interface TruthValueHolder extends Evaluable {
    public abstract void accept(PsythonVisitor v);
//    public Val eval(State st);
}
