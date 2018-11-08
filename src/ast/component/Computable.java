package ast.component;

/*
    arithmetic
    :	(ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;
*/

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;

public interface Computable extends Component {
    public abstract void accept(PsythonVisitor v);
    public Val eval(State st);
}
