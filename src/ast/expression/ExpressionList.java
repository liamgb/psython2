package ast.expression;

import ast.visitor.PsythonVisitor;

import java.util.ArrayList;
import java.util.List;

public class ExpressionList {
    public List<Expression> exp_list = new ArrayList<>();

    public ExpressionList() {
    }

    public ExpressionList(Expression exp) {
        this.exp_list.add(exp);
    }

    public void insert_expression(Expression exp) {
        this.exp_list.add(0, exp);
    }

    static public int count_tabs(String str) {
        if (str != null) {
            int counter = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '\t')
                    counter++;
            }
            return counter;
        }
        else {
            return 0;
        }
    }

    public void accept(PsythonVisitor v) {
        v.visit(this);
        for (Expression exp : this.exp_list) {
            exp.accept(v);
        }
    }
}
