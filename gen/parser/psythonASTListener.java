// Generated from C:/Users/mocli/Code/psython2/src/parser\psythonAST.g4 by ANTLR 4.7
package parser;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;
import ast.wrapper.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link psythonASTParser}.
 */
public interface psythonASTListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(psythonASTParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(psythonASTParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(psythonASTParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(psythonASTParser.ExplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(psythonASTParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(psythonASTParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#return_cmp}.
	 * @param ctx the parse tree
	 */
	void enterReturn_cmp(psythonASTParser.Return_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#return_cmp}.
	 * @param ctx the parse tree
	 */
	void exitReturn_cmp(psythonASTParser.Return_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(psythonASTParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(psythonASTParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(psythonASTParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(psythonASTParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(psythonASTParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(psythonASTParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(psythonASTParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(psythonASTParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(psythonASTParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(psythonASTParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(psythonASTParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(psythonASTParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(psythonASTParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(psythonASTParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#next_rand}.
	 * @param ctx the parse tree
	 */
	void enterNext_rand(psythonASTParser.Next_randContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#next_rand}.
	 * @param ctx the parse tree
	 */
	void exitNext_rand(psythonASTParser.Next_randContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#seed_rand}.
	 * @param ctx the parse tree
	 */
	void enterSeed_rand(psythonASTParser.Seed_randContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#seed_rand}.
	 * @param ctx the parse tree
	 */
	void exitSeed_rand(psythonASTParser.Seed_randContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void enterIf_then_else(psythonASTParser.If_then_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void exitIf_then_else(psythonASTParser.If_then_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void enterWhile_exp(psythonASTParser.While_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void exitWhile_exp(psythonASTParser.While_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#computable}.
	 * @param ctx the parse tree
	 */
	void enterComputable(psythonASTParser.ComputableContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#computable}.
	 * @param ctx the parse tree
	 */
	void exitComputable(psythonASTParser.ComputableContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#value_holder}.
	 * @param ctx the parse tree
	 */
	void enterValue_holder(psythonASTParser.Value_holderContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#value_holder}.
	 * @param ctx the parse tree
	 */
	void exitValue_holder(psythonASTParser.Value_holderContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(psythonASTParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(psythonASTParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#idlist}.
	 * @param ctx the parse tree
	 */
	void enterIdlist(psythonASTParser.IdlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#idlist}.
	 * @param ctx the parse tree
	 */
	void exitIdlist(psythonASTParser.IdlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(psythonASTParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(psythonASTParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#primitive_truth}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_truth(psythonASTParser.Primitive_truthContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#primitive_truth}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_truth(psythonASTParser.Primitive_truthContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#truth_val}.
	 * @param ctx the parse tree
	 */
	void enterTruth_val(psythonASTParser.Truth_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#truth_val}.
	 * @param ctx the parse tree
	 */
	void exitTruth_val(psythonASTParser.Truth_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonASTParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(psythonASTParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonASTParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(psythonASTParser.LiteralContext ctx);
}