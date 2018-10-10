package ast.expression;

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
public abstract class Expression {
    public int indent_lvl = 0;
    public ExpressionList block = null;

    public abstract void accept(PsythonVisitor v);
}
