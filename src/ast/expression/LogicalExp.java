package ast.expression;

import ast.wrapper.PrimitiveTruth;
import ast.wrapper.TruthValueHolder;
import ast.wrapper.ValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class LogicalExp extends Expression implements ValueHolder, TruthValueHolder {
    public String op;
    public PrimitiveTruth lhs = null;
    public PrimitiveTruth rhs = null;

    public LogicalExp(PrimitiveTruth lhs, PrimitiveTruth rhs, String op) {
        assert op.equals("and") || op.equals("or");
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }
    public LogicalExp(PrimitiveTruth operand, String operator) {
        assert operator.equals("not");
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
    public Val eval(State st) {
        switch (this.op) {
            case "and":
                boolean lhs_val = lhs.eval(st).bool_v;
                boolean rhs_val = rhs.eval(st).bool_v;
                return new Val(lhs_val && rhs_val);
            case "or":
                lhs_val = lhs.eval(st).bool_v;
                rhs_val = rhs.eval(st).bool_v;
                return new Val(lhs_val || rhs_val);
            case "not":
                lhs_val = lhs.eval(st).bool_v;
                return new Val(!lhs_val);
            default:
                assert false;
                return null;
        }
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_BOOL;
    }
}
