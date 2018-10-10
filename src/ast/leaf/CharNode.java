package ast.leaf;

import ast.visitor.PsythonVisitor;

public class CharNode implements Literal {
    public char ch;
    public CharNode( String ch ) {
        this.ch = ch.charAt(0);
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }
}
