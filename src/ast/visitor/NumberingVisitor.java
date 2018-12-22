package ast.visitor;

import ast.component.ConditionalCmp;
import ast.component.ReturnCmp;
import ast.expression.*;
import ast.leaf.*;

import java.util.ArrayList;
import java.util.List;

public class NumberingVisitor implements PsythonVisitor {
    public int counter = 0;
    public List<ExpressionList> program_strut = new ArrayList<>();
    @Override
    public void visit(ArithmeticExp arithmetic_exp) {

    }

    @Override
    public void visit(ReturnCmp return_cmp) {

    }

    @Override
    public void visit(ConditionalCmp conditional_cmp) {

    }

    @Override
    public void visit(AssignmentExp assignmentExp) {

    }

    @Override
    public void visit(ExpressionList expressionList) {
        expressionList.number = counter++;
        program_strut.add(expressionList);
    }

    @Override
    public void visit(FunctionCallExp functionCallExp) {

    }

    @Override
    public void visit(FunctionExp functionExp) {

    }

    @Override
    public void visit(IfThenElseExp ifThenElseExp) {

    }

    @Override
    public void visit(LogicalExp logicalExp) {

    }

    @Override
    public void visit(PrintExp printExp) {

    }

    @Override
    public void visit(RelationalExp relationalExp) {

    }

    @Override
    public void visit(WhileExp whileExp) {

    }

    @Override
    public void visit(BoolNode boolNode) {

    }

    @Override
    public void visit(CharNode charNode) {

    }

    @Override
    public void visit(IdentifierNode identifierNode) {

    }

    @Override
    public void visit(IntNode intNode) {

    }

    @Override
    public void visit(StringNode stringNode) {

    }

    @Override
    public void visit(NextRandExp nextRandExp) {

    }

    @Override
    public void visit(SeedRandExp seedRandExp) {

    }
    @Override
    public void visit(TailExp tail_exp){

    }
}
