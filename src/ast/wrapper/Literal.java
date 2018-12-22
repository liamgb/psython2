package ast.wrapper;

import ast.visitor.PsythonVisitor;

public interface Literal extends ValueHolder, Argument, Evaluable{
/*
    literal
    :	STRING
    |	CHAR
    |	INT
    |	BOOL
    ;
*/
    public abstract void accept(PsythonVisitor v);
//    public abstract Val eval(State st);
}
