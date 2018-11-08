package ast.expression;

import ast.component.ValueHolder;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Symbol;
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
        Symbol lhs_sym = lhs.lookup(st);
        Val res = rhs.eval(st);
        lhs_sym.v = res;
        return null;
    }
}
