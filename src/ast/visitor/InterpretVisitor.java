package ast.visitor;

import ast.component.ConditionalCmp;
import ast.component.ReturnCmp;
import ast.expression.*;
import ast.leaf.*;
import cesk.SymbolTable;
import cesk.Val;

import java.util.List;

public class InterpretVisitor implements PsythonVisitor{

    public String scope_name = null; // null is global, anything else is scoped
    public SymbolTable symbol_table = new SymbolTable();

    public InterpretVisitor(SymbolTable st){
        this.symbol_table = st;
    }

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
        List<Expression> list = expressionList.exp_list;
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
}
