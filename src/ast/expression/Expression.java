package ast.expression;

import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.SymbolTable;
import cesk.Val;

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
public abstract class Expression {
    public int indent_lvl = 0;
    public ExpressionList block = null;

    public abstract void accept(PsythonVisitor v);

    public abstract Val eval(State st);
}
