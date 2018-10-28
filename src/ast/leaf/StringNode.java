package ast.leaf;

import ast.visitor.PsythonVisitor;
import cesk.ValueType;

public class StringNode implements Literal{
    public String str;
    public StringNode( String str ) {
        this.str = str;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_STR;
    }
}
