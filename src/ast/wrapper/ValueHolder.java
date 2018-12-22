package ast.wrapper;


import ast.wrapper.Evaluable;
import ast.visitor.PsythonVisitor;
import cesk.ValueType;

//ID | literal | arithmetic | relational | logical | function_call
public interface ValueHolder extends Evaluable {
    void accept(PsythonVisitor v);
    ValueType get_type();
//    Val eval(State st);
}
