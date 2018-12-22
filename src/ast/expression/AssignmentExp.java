package ast.expression;

import ast.wrapper.ValueHolder;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

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

    @Override
    public Val eval(State st) {
        Val res = rhs.eval(st);
        lhs.lookup(st).v = res;
        return null;
    }
}
