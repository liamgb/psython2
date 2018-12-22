package ast.wrapper;

// Function, Identifier, FunctionCall

import ast.wrapper.Evaluable;

public interface Variable extends Evaluable {
    public String get_name();
}
