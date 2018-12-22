package ast.expression;

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

public class TailExp extends Expression {

    public TailExp() {
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public Val eval(State st) {
        return null;
    }
}
