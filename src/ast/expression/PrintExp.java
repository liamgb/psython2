package ast.expression;

import ast.wrapper.Argument;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

import java.util.List;

public class PrintExp extends Expression {
    public List<Argument> arg_list;

    public PrintExp(List<Argument> arg_list) {
        this.arg_list = arg_list;
    }
    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        for (Argument arg : arg_list){
            arg.accept(v);
        }
    }

    @Override
    public Val eval(State st) {
        System.out.println(arg_list.stream().map(
                e -> e.eval(st).toString()).reduce(" ", String::concat));
        return null;
    }
}
