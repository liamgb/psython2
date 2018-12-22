package ast.wrapper;

//ID | BOOL | relational

import ast.wrapper.Evaluable;
import ast.visitor.PsythonVisitor;

public interface PrimitiveTruth extends Evaluable {
    public abstract void accept(PsythonVisitor v);
//    public Val eval(State st);
}
