package ast.expression;

import ast.wrapper.Computable;
import ast.wrapper.PrimitiveTruth;
import ast.wrapper.TruthValueHolder;
import ast.wrapper.ValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

public class RelationalExp extends Expression implements ValueHolder, TruthValueHolder, PrimitiveTruth {
    public String op;
    public Computable lhs;
    public Computable rhs;

    public RelationalExp(Computable lhs, Computable rhs, String op) {
        assert op.equals(">") || op.equals(">=") || op.equals("==") ||
                op.equals("!=") || op.equals("<") || op.equals("<=");
        this.lhs = lhs;
        this.rhs = rhs;
        this.op = op;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        lhs.accept(v);
        rhs.accept(v);
    }

    @Override
    public Val eval(State st) {
        if (lhs.eval(st) == null) {
            if (rhs.eval(st) == null)
                return new Val(true);
            else
                return new Val(false);
        }

        int lhs_val = lhs.eval(st).int_v;
        int rhs_val = rhs.eval(st).int_v;
        switch (this.op) {
            case ">":
                return new Val(lhs_val > rhs_val);
            case ">=":
                return new Val(lhs_val >= rhs_val);
            case "==":
                return new Val(lhs_val == rhs_val);
            case "!=":
                return new Val(lhs_val != rhs_val);
            case "<":
                return new Val(lhs_val < rhs_val);
            case "<=":
                return new Val(lhs_val <= rhs_val);
            default:
                assert false;
                return null;
        }
    }

//    @Override
//    public Val echo(State st) {
//        return null;
//    }

    @Override
    public ValueType get_type() {
        return ValueType.P_BOOL;
    }
}
