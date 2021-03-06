package ast.expression;

import ast.component.ReturnCmp;
import ast.wrapper.Variable;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

import java.util.ArrayList;
import java.util.List;

/*
function
    :	'def' ID '(' idlist ')' ':' endls
        explist
        tabs return
    ;
*/

public class FunctionExp extends Expression implements Variable {
    public IdentifierNode func_id;
    public List<IdentifierNode> func_args = new ArrayList<>();
    public ExpressionList func_body;
    public ReturnCmp ret_cmp;
    public TailExp tail = new TailExp();

    public FunctionExp(IdentifierNode func_id, List<IdentifierNode> func_args,
                       ExpressionList expl, ReturnCmp ret_cmp) {
        this.func_id = func_id;
        this.func_args = func_args;
        this.func_body = expl;
        this.ret_cmp = ret_cmp;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
        func_id.accept(v);
        for(IdentifierNode arg : func_args){
            arg.accept(v);
        }
        func_body.accept(v);
        ret_cmp.accept(v);
        tail.accept(v);
    }

    @Override
    public Val eval(State st) {
        return null;
    }

    public Val eval_func(State st) {
        return null;
    }

    @Override
    public String get_name() {
        return this.func_id.id_name;
    }
}
