package ast.expression;

import ast.component.ConditionalCmp;
import ast.component.TruthValueHolder;
import ast.visitor.PsythonVisitor;

import java.util.ArrayList;
import java.util.List;

public class IfThenElseExp extends Expression {
    public ConditionalCmp if_statement;
    public List<ConditionalCmp> elif_statements = new ArrayList<>();
    public ExpressionList else_body = null;

    public IfThenElseExp(TruthValueHolder if_cond, ExpressionList if_body){
        this.if_statement = new ConditionalCmp(if_cond, if_body);
    }

    public void create_elif_statement(TruthValueHolder elif_cond, ExpressionList elif_body) {
        this.elif_statements.add(new ConditionalCmp(elif_cond, elif_body));
    }

    public void create_else_body(ExpressionList else_content) {
        this.else_body = else_content;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        this.if_statement.accept(v);
        for (ConditionalCmp elif : this.elif_statements){
            elif.accept(v);
        }
        if (this.else_body != null) {
            this.else_body.accept(v);
        }
    }
}
