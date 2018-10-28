package ast.expression;

import ast.component.PrimitiveTruth;
import ast.component.TruthValueHolder;
import ast.component.ValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.ValueType;

public class LogicalExp extends Expression implements ValueHolder, TruthValueHolder {
    public String op;
    public PrimitiveTruth lhs = null;
    public PrimitiveTruth rhs = null;

    public LogicalExp(PrimitiveTruth lhs, PrimitiveTruth rhs, String op) {
        assert op == "and" || op == "or";
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }
    public LogicalExp(PrimitiveTruth operand, String operator) {
        assert operator == "not";
        this.op = operator;
        this.lhs = operand;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        lhs.accept(v);
        if (rhs != null){
            rhs.accept(v);
        }
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_BOOL;
    }
}
