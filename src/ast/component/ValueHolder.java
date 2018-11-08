package ast.component;


import ast.visitor.PsythonVisitor;
import cesk.State;
import cesk.Val;
import cesk.ValueType;

//ID | literal | arithmetic | relational | logical | function_call
public interface ValueHolder {
    void accept(PsythonVisitor v);
    ValueType get_type();
    Val eval(State st);
}
