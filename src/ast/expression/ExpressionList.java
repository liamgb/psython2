package ast.expression;

import ast.visitor.PsythonVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExpressionList {
    public int number = -1;
    public List<Expression> exp_list = new ArrayList<>();

    public ExpressionList() {
    }

    public ExpressionList(ExpressionList el) {
//        this.exp_list
    }

    public ExpressionList(Expression exp) {
        this.exp_list.add(exp);
    }

    public void insert_expression(Expression exp) {
        this.exp_list.add(0, exp);
    }

    public void accept(PsythonVisitor v) {
        v.visit(this);
        for (Expression exp : this.exp_list) {
            exp.accept(v);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpressionList)) return false;
        ExpressionList that = (ExpressionList) o;
        return exp_list.equals(that.exp_list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(exp_list);
    }
}
