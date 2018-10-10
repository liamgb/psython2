package ast.component;


import ast.visitor.PsythonVisitor;

//ID | literal | arithmetic | relational | logical | function_call
public interface ValueHolder {
    void accept(PsythonVisitor v);
}
