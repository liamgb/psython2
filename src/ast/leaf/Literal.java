package ast.leaf;

import ast.component.ValueHolder;
import ast.visitor.PsythonVisitor;

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
}
