package ast.leaf;

import ast.component.*;
import ast.visitor.PsythonVisitor;

public class IdentifierNode implements Argument, Computable, ValueHolder, TruthValueHolder, PrimitiveTruth {
    public String id_name;
    public IdentifierNode( String id_name ) {
        this.id_name = id_name;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }
}
