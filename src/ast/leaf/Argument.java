package ast.leaf;

import ast.visitor.PsythonVisitor;

public interface Argument {
/*
    argument
    :	ID | literal
    ;
*/
    public abstract void accept(PsythonVisitor v);
}
