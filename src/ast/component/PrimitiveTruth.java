package ast.component;

//ID | BOOL | relational

import ast.visitor.PsythonVisitor;

public interface PrimitiveTruth {
    public abstract void accept(PsythonVisitor v);
}
