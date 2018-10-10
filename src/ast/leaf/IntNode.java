package ast.leaf;

import ast.component.Computable;
import ast.visitor.PsythonVisitor;

public class IntNode implements Literal, Computable {
    public String str;
    public IntNode( String str ) {
        this.str = str;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }
}
