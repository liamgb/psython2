package ast.leaf;

import ast.component.*;
import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Symbol;
import cesk.Val;
import cesk.ValueType;

public class IdentifierNode implements Variable, Argument, Computable, ValueHolder, TruthValueHolder, PrimitiveTruth {
    public String id_name;
    public IdentifierNode( String id_name ) {
        this.id_name = id_name;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }

    @Override
    public Val eval(State st) {
        return st.environment.lookup(st.scope, id_name).v;
    }

    public Symbol lookup(State st) {
        return st.environment.lookup(st.scope, id_name);
    }

    @Override
    public ValueType get_type() {
        return ValueType.P_UNKNOWN;
    }

    @Override
    public String get_name() {
        return this.id_name;
    }
}
