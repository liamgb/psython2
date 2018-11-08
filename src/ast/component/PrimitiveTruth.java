package ast.component;

//ID | BOOL | relational

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

public interface PrimitiveTruth {
    public abstract void accept(PsythonVisitor v);
    public Val eval(State st);
}
