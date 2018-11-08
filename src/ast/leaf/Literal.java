package ast.leaf;

import ast.component.ValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

public interface Literal extends ValueHolder, Argument {
/*
    literal
    :	STRING
    |	CHAR
    |	INT
    |	BOOL
    ;
*/
    public abstract void accept(PsythonVisitor v);
    public abstract Val eval(State st);
}
