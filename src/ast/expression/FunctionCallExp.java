package ast.expression;

import ast.wrapper.ValueHolder;
import ast.wrapper.Variable;
import ast.wrapper.Argument;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

import java.util.List;

/*
    function_call
    :	ID '(' arglist ')'
    ;
*/

public class FunctionCallExp extends Expression implements ValueHolder, Variable {
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

    @Override
    public Val eval(State st) {
        return null;
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_UNKNOWN;
    }

    @Override
    public String get_name() {
        return this.id.id_name;
    }
}
