package ast.leaf;

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class CharNode implements Literal {
    public char ch;
    public CharNode( String ch ) {
        this.ch = ch.charAt(0);
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_CHAR;
    }

    @Override
    public Val eval(State st) {
        return new Val(Character.valueOf(ch));
    }
}
