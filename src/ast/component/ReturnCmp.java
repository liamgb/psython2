package ast.component;

import ast.expression.ExpressionList;
import ast.leaf.Argument;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

/*
    return 	:	'return' arglist
    ;
*/

public class ReturnCmp implements Component{
    public Argument arg;
    public ReturnCmp(Argument arg) {
        this.arg = arg;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        arg.accept(v);
    }

    public Val eval(State st) {
        return arg.eval(st);
    }
}