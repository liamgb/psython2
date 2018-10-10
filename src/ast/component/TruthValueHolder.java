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

public interface TruthValueHolder {
    public abstract void accept(PsythonVisitor v);
}
