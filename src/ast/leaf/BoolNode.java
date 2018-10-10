package ast.leaf;

import ast.component.PrimitiveTruth;
import ast.component.TruthValueHolder;
import ast.visitor.PsythonVisitor;

public class BoolNode  implements Literal, TruthValueHolder, PrimitiveTruth {
    public String boolval;
    public BoolNode( String boolval ) {
        this.boolval = boolval;
    }

    @Override
    public void accept(PsythonVisitor v) {
        v.visit(this);
    }
}
