package ast.expression;

import ast.component.ValueHolder;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;

/*
    assignment
    :	ID '=' (ID | literal | arithmetic | relational | logical | function_call)
    ;
*/

public class AssignmentExp extends Expression{
    public IdentifierNode lhs;
    public ValueHolder rhs;

    public AssignmentExp(IdentifierNode lhs, ValueHolder rhs){
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        lhs.accept(v);
        rhs.accept(v);
    }
}
