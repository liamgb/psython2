package ast.expression;

import ast.component.ConditionalCmp;
import ast.wrapper.TruthValueHolder;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

import java.util.ArrayList;
import java.util.List;

public class IfThenElseExp extends Expression {
    public ConditionalCmp if_statement;
//    public List<ConditionalCmp> elif_statements = new ArrayList<>();
    public ExpressionList else_body = null;
    public TailExp tail = new TailExp();

    public IfThenElseExp(TruthValueHolder if_cond, ExpressionList if_body){
        this.if_statement = new ConditionalCmp(if_cond, if_body);
    }

//    public void create_elif_statement(TruthValueHolder elif_cond, ExpressionList elif_body) {
//        this.elif_statements.add(new ConditionalCmp(elif_cond, elif_body));
//    }

    public void create_else_body(ExpressionList else_content) {
        this.else_body = else_content;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        this.if_statement.accept(v);

//        for (ConditionalCmp elif : this.elif_statements){
//            elif.accept(v);
//        }
        if (this.else_body != null) {
            this.else_body.accept(v);
        }

        tail.accept(v);
    }

    @Override
    public Val eval(State st) {
//        if (if_statement.if_cond.eval(st).bool_v) {
//            for (Expression exp : if_statement.if_body.exp_list) {
//                exp.eval(st);
//            }
//            return null;
//        }
//        for (ConditionalCmp cmp : elif_statements) {
//            if (cmp.if_cond.eval(st).bool_v) {
//                for (Expression exp : cmp.if_body.exp_list) {
//                    exp.eval(st);
//                }
//                return null;
//            }
//        }
//        if (else_body != null) {
//            for (Expression exp : else_body.exp_list) {
//                exp.eval(st);
//            }
//            return null;
//        }
        return null;
    }
}
