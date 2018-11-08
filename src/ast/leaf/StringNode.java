package ast.leaf;

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class StringNode implements Literal{
    public String str;
    public StringNode( String str ) {
        this.str = str.substring(1, str.length()-1);
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_STR;
    }

    @Override
    public Val eval(State st) {
        return new Val(str);
    }
}
