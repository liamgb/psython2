package ast.component;

/*
    arithmetic
    :	(ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;
*/

import ast.visitor.PsythonVisitor;

public interface Computable extends Component {
    public abstract void accept(PsythonVisitor v);
}
