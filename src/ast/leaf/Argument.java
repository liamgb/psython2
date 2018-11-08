package ast.leaf;

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public interface Argument {
/*
    argument
    :	ID | literal
    ;
*/
    public abstract void accept(PsythonVisitor v);
    public ValueType get_type();
    public Val eval(State st);
}
