package ast.component;

import ast.expression.Expression;
import ast.expression.ExpressionList;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

/*
if_then_else
    :	'if' truth_val ':' endls explist
    (tabs 'elif' truth_val ':' endls explist)*
    (tabs 'else' ':' endls explist)?
    tabs PASS
    ;
*/

public class ConditionalCmp implements Component{
    public TruthValueHolder if_cond;
    public ExpressionList if_body = null;

    public ConditionalCmp(TruthValueHolder if_cond, ExpressionList exp_list){
        this.if_cond = if_cond;
        this.if_body = exp_list;
    }

    public void append_body(Expression if_body){
        this.if_body.insert_expression(if_body);
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        if_cond.accept(v);
        if_body.accept(v);
    }
}
