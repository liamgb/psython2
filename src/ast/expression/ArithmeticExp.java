package ast.expression;

import ast.component.Computable;
import ast.component.ValueHolder;
import ast.visitor.PsythonVisitor;

/*
    arithmetic
    :	(ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;
*/

public class ArithmeticExp extends Expression implements ValueHolder {
    public Computable lhs;
    public Computable rhs;
    public String op;

    public ArithmeticExp(Computable lhs, Computable rhs, String op){
        assert op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
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
}
