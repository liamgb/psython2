package ast.visitor;

import ast.atomic.*;
import ast.component.ConditionalCmp;
import ast.component.ReturnCmp;
import ast.expression.*;
import ast.leaf.*;

import java.util.Stack;

public class AtomicVisitor implements PsythonVisitor{
    public boolean allow_side_effect = true;
    public ImperativeProg imperative_prog = ImperativeProg.get_singleton();
    Stack<AtomicExe> uninit_ctrl = new Stack<>();

    public AtomicVisitor(boolean allow_side_effect) {
        this.allow_side_effect = allow_side_effect;
    }


    @Override
    public void visit(ArithmeticExp arithmetic_exp) {

    }

    @Override
    public void visit(ReturnCmp return_cmp) {
        imperative_prog.add(new FunReturn(return_cmp));
    }

    @Override
    public void visit(ConditionalCmp conditional_cmp) {
        FlowController fc = new FlowController(
                conditional_cmp.if_cond, FlowType.IF, false);
        imperative_prog.add(fc);
        uninit_ctrl.push(fc);
    }

    @Override
    public void visit(AssignmentExp assignmentExp) {
        if (assignmentExp.rhs instanceof FunctionCallExp) {
            imperative_prog.add(new FuncAssign(assignmentExp));
        }
        else if (assignmentExp.rhs instanceof NextRandExp) {
            imperative_prog.add(new RandAssign(assignmentExp));
        }
        else {
            imperative_prog.add(new SimpleAssign(assignmentExp));
        }
    }

    @Override
    public void visit(ExpressionList expressionList) {

    }

    @Override
    public void visit(FunctionCallExp functionCallExp) {

    }

    @Override
    public void visit(FunctionExp functionExp) {
        FuncDef fd = new FuncDef(functionExp.get_name(), imperative_prog.size());
        imperative_prog.add(fd);
        uninit_ctrl.push(fd);
    }

    @Override
    public void visit(IfThenElseExp ifThenElseExp) {

    }

    @Override
    public void visit(LogicalExp logicalExp) {

    }

    @Override
    public void visit(PrintExp printExp) {
        if (allow_side_effect) {
            imperative_prog.add(new SideEffect(printExp));
        }
    }

    @Override
    public void visit(RelationalExp relationalExp) {

    }

    @Override
    public void visit(WhileExp whileExp) {
        FlowController fc = new FlowController(
                whileExp.while_cond, FlowType.WHILE, false);
        imperative_prog.add(fc);
        uninit_ctrl.push(fc);
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
        AtomicExe begin_ae = uninit_ctrl.pop();

        if (begin_ae instanceof FlowController) {
            FlowController begin_fc = (FlowController) begin_ae;
            FlowController fc;

            switch (begin_fc.fc) {
                case IF:
                    // init begin flow controller
                    begin_fc.goto_counter = imperative_prog.size() - 1;

                    // skip the rest if the previous is true
                    fc = new FlowController(
                            begin_fc.tvh, FlowType.ELSE, true);
                    imperative_prog.add(fc);
                    uninit_ctrl.push(fc);

                    break;

                case ELSE:
                    // init begin flow controller
                    begin_fc.goto_counter = imperative_prog.size() - 1;

                    break;

                case WHILE:
                    // build ending flow controller
                    fc = new FlowController(
                            new BoolNode("False"), FlowType.WHILE, false);
                    fc.goto_counter = imperative_prog.indexOf(begin_fc) - 1;
                    imperative_prog.add(fc);

                    // init begin flow controller
                    begin_fc.goto_counter = imperative_prog.size() - 1;
                    break;

                default:
                    assert false;
                    break;
            }
        } else { // function definition
            FuncDef begin_fd = (FuncDef) begin_ae;
            begin_fd.end_position = imperative_prog.size() - 1; // goto the assign
        }
    }
}
