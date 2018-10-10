package ast.visitor;

import ast.component.ConditionalCmp;
import ast.component.ReturnCmp;
import ast.expression.*;
import ast.leaf.*;


public class PrettyPrintVisitor implements PsythonVisitor {

    public StringBuilder result = new StringBuilder();


    @Override
    public void visit(ArithmeticExp arithmetic_exp) {
        result.append(arithmetic_exp.op + "\n");
    }

    @Override
    public void visit(ReturnCmp return_cmp) {

    }

    @Override
    public void visit(ConditionalCmp conditional_cmp) {
        result.append("Conditional:\n");
    }

    @Override
    public void visit(AssignmentExp assignmentExp) {
        result.append("Assignment\n");
    }

    @Override
    public void visit(ExpressionList expressionList) {
        result.append("Expression List:\n");
    }

    @Override
    public void visit(FunctionCallExp functionCallExp) {

    }

    @Override
    public void visit(FunctionExp functionExp) {

    }

    @Override
    public void visit(IfThenElseExp ifThenElseExp) {
        result.append("If the else statement:\n");
    }

    @Override
    public void visit(LogicalExp logicalExp) {

    }

    @Override
    public void visit(PrintExp printExp) {

    }

    @Override
    public void visit(RelationalExp relationalExp) {
        result.append(relationalExp.op + "\n");
    }

    @Override
    public void visit(WhileExp whileExp) {
        result.append("While:\n");
    }

    @Override
    public void visit(BoolNode boolNode) {
        result.append(boolNode.boolval + "\n");
    }

    @Override
    public void visit(CharNode charNode) {
        result.append(charNode.ch + "\n");
    }

    @Override
    public void visit(IdentifierNode identifierNode) {
        result.append(identifierNode.id_name + "\n");
    }

    @Override
    public void visit(IntNode intNode) {
        result.append(intNode.str + "\n");
    }

    @Override
    public void visit(StringNode stringNode) {
        result.append(stringNode.str + "\n");
    }


//    @Override
//    public void visit(Expression item) {
//        result.append("Expression\n");
//    }
}
