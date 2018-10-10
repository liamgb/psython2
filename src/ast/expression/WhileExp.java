package ast.expression;

import ast.component.TruthValueHolder;
import ast.visitor.PsythonVisitor;

public class WhileExp extends Expression {
    public TruthValueHolder while_cond;
    public ExpressionList while_body = null;

    public WhileExp(TruthValueHolder while_cond, ExpressionList explist){
        this.while_cond = while_cond;
        this.while_body = explist;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        while_cond.accept(v);
        while_body.accept(v);
    }
}