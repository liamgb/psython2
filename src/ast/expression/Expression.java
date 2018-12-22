package ast.expression;

import ast.wrapper.Evaluable;
import ast.visitor.PsythonVisitor;

/*
    expression
    :	function_call
    | 	assignment
    | 	function
    |	arithmetic
    |	relational
    | 	logical
    | 	print
    | 	if_then_else
    |	while
    ;
*/
public abstract class Expression implements Evaluable {
    public abstract void accept(PsythonVisitor v);

//    public abstract Val eval(State st);
//    public abstract Val echo(State st);
}
