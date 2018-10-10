package ast.visitor;

import ast.component.ConditionalCmp;
import ast.component.ReturnCmp;
import ast.component.TruthValueHolder;
import ast.expression.*;
import ast.leaf.*;

public interface PsythonVisitor {
    void visit(ArithmeticExp arithmetic_exp);
    void visit(ReturnCmp return_cmp);
    void visit(ConditionalCmp conditional_cmp);

    void visit(AssignmentExp assignmentExp);

    void visit(ExpressionList expressionList);

    void visit(FunctionCallExp functionCallExp);

    void visit(FunctionExp functionExp);

    void visit(IfThenElseExp ifThenElseExp);

    void visit(LogicalExp logicalExp);

    void visit(PrintExp printExp);

    void visit(RelationalExp relationalExp);

    void visit(WhileExp whileExp);

    void visit(BoolNode boolNode);

    void visit(CharNode charNode);

    void visit(IdentifierNode identifierNode);

    void visit(IntNode intNode);

    void visit(StringNode stringNode);

//    void visit(Expression item);
}
