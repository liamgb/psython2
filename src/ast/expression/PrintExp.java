package ast.expression;

import ast.leaf.Argument;
import ast.visitor.PsythonVisitor;

public class PrintExp extends Expression {
    public Argument argument;

    public PrintExp(Argument argument) {
        this.argument = argument;
    }
    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        argument.accept(v);
    }
}
