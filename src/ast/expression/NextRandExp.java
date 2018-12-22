package ast.expression;

import ast.wrapper.ValueHolder;
import ast.wrapper.Argument;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

import java.util.Random;

import static cesk.ValueType.P_INT;

public class NextRandExp extends Expression implements ValueHolder, Argument {
    public static final int rand_bound = 4;
    public Random ran = new Random();
    public NextRandExp() {

    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public Val eval(State st) {
        int rand = ran.nextInt(rand_bound);
        return new Val(rand);
    }

    public ValueType get_type() {
        return P_INT;
    }

}
