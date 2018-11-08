package ast.expression;

import ast.component.TruthValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

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

    @Override
    public Val eval(State st) {
        while(while_cond.eval(st).bool_v) {
            for (Expression exp : while_body.exp_list){
                exp.eval(st);
            }
        }
        return null;
    }
}
