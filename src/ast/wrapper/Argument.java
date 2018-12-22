package ast.wrapper;

import ast.wrapper.Evaluable;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public interface Argument extends Evaluable {
/*
    argument
    :	ID | literal
    ;
*/
    public abstract void accept(PsythonVisitor v);
    public ValueType get_type();
    public Val eval(State st);
}
