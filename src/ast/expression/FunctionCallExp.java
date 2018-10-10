package ast.expression;

import ast.component.ValueHolder;
import ast.leaf.Argument;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;

import java.util.ArrayList;
import java.util.List;

/*
    function_call
    :	ID '(' arglist ')'
    ;
*/

public class FunctionCallExp extends Expression implements ValueHolder {
    public IdentifierNode id;
    public List<Argument> arg_list;

    public FunctionCallExp(IdentifierNode id, List<Argument> arg_list) {
        this.id = id;
        this.arg_list = arg_list;
    }


    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        id.accept(v);
        for (Argument arg : arg_list){
            arg.accept(v);
        }
    }
}
