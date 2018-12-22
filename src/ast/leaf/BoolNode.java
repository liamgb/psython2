package ast.leaf;

import ast.wrapper.PrimitiveTruth;
import ast.wrapper.TruthValueHolder;
import ast.wrapper.Literal;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class BoolNode implements Literal, TruthValueHolder, PrimitiveTruth {
    public String boolval;
    public BoolNode( String boolval ) {
        this.boolval = boolval;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_BOOL;
    }

    @Override
    public Val eval(State st) {
        return new Val(Boolean.valueOf(boolval.toLowerCase()));
    }
}
