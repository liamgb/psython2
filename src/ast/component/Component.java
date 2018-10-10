package ast.component;

import ast.visitor.PsythonVisitor;

public interface Component {
    public abstract void accept(PsythonVisitor v);
}
