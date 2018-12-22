package ast.leaf;

import ast.wrapper.Computable;
import ast.wrapper.Literal;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class IntNode implements Literal, Computable {
    public String str;
    public IntNode( String str ) {
        this.str = str;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_INT;
    }

    @Override
    public Val eval(State st) {
        return new Val(Integer.valueOf(str));
    }
}
