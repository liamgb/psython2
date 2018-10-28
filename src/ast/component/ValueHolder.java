package ast.component;


import ast.visitor.PsythonVisitor;
import cesk.ValueType;

//ID | literal | arithmetic | relational | logical | function_call
public interface ValueHolder {
    void accept(PsythonVisitor v);
    ValueType get_type();
}
