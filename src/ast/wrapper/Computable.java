package ast.wrapper;

/*
    arithmetic
    :	(ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;
*/

import ast.component.Component;
import ast.visitor.PsythonVisitor;

public interface Computable extends Component, Evaluable {
    public abstract void accept(PsythonVisitor v);
//    public Val eval(State st);
}
