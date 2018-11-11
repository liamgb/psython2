package ast.expression;

import ast.component.ValueHolder;
import ast.component.Variable;
import ast.leaf.Argument;
import ast.leaf.IdentifierNode;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

import java.util.ArrayList;
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
        // push new frame
        st.interrupt(this, this.get_name(), this.arg_list);

        // eval function
        while(true) {
            Expression exp = st.next();
            if (exp != null)
                exp.eval(st);
            else
                break;
        }
        FunctionExp func_def = (FunctionExp) st.environment.lookup(null, this.get_name()).var;
        Val result = func_def.ret_cmp.eval(st);

        // pop old frame and cont.
        st.kont();
        return result;
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
