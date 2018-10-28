package ast.visitor;

import ast.component.*;
import ast.expression.*;
import ast.leaf.*;
import cesk.Symbol;
import cesk.ValueType;
import cesk.SymbolTable;


import java.util.List;
import java.util.TreeMap;


public class SymbolTableBuildingVisitor implements PsythonVisitor{
    public String scope_name = null; // null is global, anything else is scoped
    public SymbolTable result = new SymbolTable();

    public SymbolTableBuildingVisitor(){
    }
    public SymbolTableBuildingVisitor(SymbolTable pre_result){
        this.result = pre_result;
    }

    private boolean is_defined(Object ob) {
        if (ob instanceof Variable) {
            Symbol sym = this.result.lookup(this.scope_name,
                    ((Variable) ob).get_name());
            return sym != null;
        }
        else {
            return true;
        }
    }

    @Override
    public void visit(ArithmeticExp arithmetic_exp) {
        if (!is_defined(arithmetic_exp.lhs) || !is_defined(arithmetic_exp.rhs)) {
            System.out.println("Variable undefined before used");
            assert false;
        }

        Computable lhs = arithmetic_exp.lhs;
        Computable rhs = arithmetic_exp.rhs;
        if (lhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt = ValueType.P_INT;
        }
        if (rhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt = ValueType.P_INT;
        }
    }

    @Override
    public void visit(ReturnCmp return_cmp) {
        this.scope_name = null;
    }

    @Override
    public void visit(ConditionalCmp conditional_cmp) {

    }

    @Override
    public void visit(AssignmentExp assignmentExp) {
        // TODO: insert
        ValueType rhs_vt = assignmentExp.rhs.get_type();

        if (rhs_vt == ValueType.P_UNKNOWN) { // check rhs
            Symbol rhs_sym = this.result.lookup(this.scope_name, ((Variable) assignmentExp.rhs).get_name());
            if (rhs_sym != null) {
                rhs_vt = this.result.lookup(this.scope_name, ((Variable) assignmentExp.rhs).get_name()).vt;
            }
            else {
                if (!((Variable) assignmentExp.rhs).get_name().equals(this.scope_name)){
                    System.out.println(((Variable) assignmentExp.rhs).get_name() + " is used before defined.");
                    assert false;
                }
            }
        }
        if (rhs_vt != ValueType.P_UNKNOWN) {
            this.result.insert(this.scope_name, (assignmentExp.lhs).get_name(),
                    new Symbol(rhs_vt, assignmentExp.lhs));
        }
    }

    @Override
    public void visit(ExpressionList expressionList) {

    }

    @Override
    public void visit(FunctionCallExp functionCallExp) {
        Symbol func_def = this.result.lookup(null, functionCallExp.get_name());

        if (func_def != null){
            List<IdentifierNode> def_args = ((FunctionExp) func_def.var).func_args;
            List<Argument> call_args = functionCallExp.arg_list;

            if (call_args.size() != def_args.size()) {
                System.out.println(functionCallExp.get_name() + " arg list size not match.");
                assert false;
            }

            for (int i = 0 ; i < call_args.size(); i++) {
                Argument ca = call_args.get(i);
                IdentifierNode fa = def_args.get(i);
                ValueType ca_type = ValueType.P_UNKNOWN;

                if (ca instanceof IdentifierNode) {
                    if (this.result.lookup(this.scope_name, ((IdentifierNode) ca).id_name) != null) {
                        ca_type = this.result.lookup(this.scope_name, ((IdentifierNode) ca).id_name).vt;
                    }
                    else {
                        System.out.println(functionCallExp.get_name() + " function arg not definted.");
                        assert false;
                    }
                }
                else {  // if ca is literal
                    ca_type = ca.get_type();
                }

                if (fa.get_type() != ValueType.P_UNKNOWN) {
                    if (ca_type != fa.get_type()) {
                        System.out.println(functionCallExp.get_name() + " function arg not match.");
                        assert false;
                    }
                }
                else {
                    this.result.lookup(
                            null,
                            functionCallExp.get_name()).anatomy.put(
                                    fa.get_name(), new Symbol(ca_type, null));
                }
            }
        }
    }

    @Override
    public void visit(FunctionExp functionExp) {
        // TODO: insert
        Symbol func = this.result.lookup(null, functionExp.get_name());
        if (func == null){
            ValueType rtvt = functionExp.ret_cmp.arg.get_type();

            Symbol sym = new Symbol(new TreeMap<>(), rtvt, functionExp);
            this.result.insert(null, functionExp.get_name(), sym);

            // build local vars
            List<IdentifierNode> func_args = functionExp.func_args;
            for (IdentifierNode idn : func_args) {
                this.result.lookup(null, functionExp.get_name()).anatomy.put(
                        idn.id_name, new Symbol(ValueType.P_UNKNOWN, null));
            }
        }
        else { // second pass
            ValueType rtvt = functionExp.ret_cmp.arg.get_type();

            if (rtvt == ValueType.P_UNKNOWN) {
                String rt_name = ((IdentifierNode) functionExp.ret_cmp.arg).get_name();

                if (this.result.lookup(null, functionExp.get_name()) != null &&
                        this.result.lookup(functionExp.get_name(), rt_name) != null) {
                    rtvt = this.result.lookup(functionExp.get_name(), rt_name).vt;
                }
            }

            Symbol sym = new Symbol(func.anatomy, rtvt, functionExp);
            this.result.insert(null, functionExp.get_name(), sym);
        }

        this.scope_name = functionExp.func_id.id_name;
    }

    @Override
    public void visit(IfThenElseExp ifThenElseExp) {

    }

    @Override
    public void visit(LogicalExp logicalExp) {
        if (!is_defined(logicalExp.lhs) || !is_defined(logicalExp.rhs)) {
            System.out.println("Variable undefined before used");
            assert false;
        }

        PrimitiveTruth lhs = logicalExp.lhs;
        PrimitiveTruth rhs = logicalExp.rhs;
        if (lhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt = ValueType.P_BOOL;
        }
        if (rhs != null &&
                rhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt = ValueType.P_BOOL;
        }
    }

    @Override
    public void visit(PrintExp printExp) {

    }

    @Override
    public void visit(RelationalExp relationalExp) {
        if (!is_defined(relationalExp.lhs) || !is_defined(relationalExp.rhs)) {
            System.out.println("Variable undefined before used");
            assert false;
        }

        Computable lhs = relationalExp.lhs;
        Computable rhs = relationalExp.rhs;
        if (lhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) lhs).id_name).vt = ValueType.P_INT;
        }
        if (rhs instanceof IdentifierNode &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name) != null &&
                this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt == ValueType.P_UNKNOWN) {
            this.result.lookup(this.scope_name, ((IdentifierNode) rhs).id_name).vt = ValueType.P_INT;
        }
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


//    @Override
//    public void visit(Expression item) {
//        result.append("Expression\n");
//    }
}
