// Generated from C:/Users/mocli/Code/psython2/src/parser\psython.g4 by ANTLR 4.7
package parser;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link psythonParser}.
 */
public interface psythonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link psythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(psythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(psythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#explist}.
	 * @param ctx the parse tree
	 */
	void enterExplist(psythonParser.ExplistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#explist}.
	 * @param ctx the parse tree
	 */
	void exitExplist(psythonParser.ExplistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(psythonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(psythonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#return_cmp}.
	 * @param ctx the parse tree
	 */
	void enterReturn_cmp(psythonParser.Return_cmpContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#return_cmp}.
	 * @param ctx the parse tree
	 */
	void exitReturn_cmp(psythonParser.Return_cmpContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(psythonParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(psythonParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(psythonParser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(psythonParser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(psythonParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(psythonParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void enterArithmetic(psythonParser.ArithmeticContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#arithmetic}.
	 * @param ctx the parse tree
	 */
	void exitArithmetic(psythonParser.ArithmeticContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(psythonParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(psythonParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#logical}.
	 * @param ctx the parse tree
	 */
	void enterLogical(psythonParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#logical}.
	 * @param ctx the parse tree
	 */
	void exitLogical(psythonParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(psythonParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(psythonParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#next_rand}.
	 * @param ctx the parse tree
	 */
	void enterNext_rand(psythonParser.Next_randContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#next_rand}.
	 * @param ctx the parse tree
	 */
	void exitNext_rand(psythonParser.Next_randContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#seed_rand}.
	 * @param ctx the parse tree
	 */
	void enterSeed_rand(psythonParser.Seed_randContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#seed_rand}.
	 * @param ctx the parse tree
	 */
	void exitSeed_rand(psythonParser.Seed_randContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void enterIf_then_else(psythonParser.If_then_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#if_then_else}.
	 * @param ctx the parse tree
	 */
	void exitIf_then_else(psythonParser.If_then_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void enterWhile_exp(psythonParser.While_expContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#while_exp}.
	 * @param ctx the parse tree
	 */
	void exitWhile_exp(psythonParser.While_expContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(psythonParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(psythonParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#idlist}.
	 * @param ctx the parse tree
	 */
	void enterIdlist(psythonParser.IdlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#idlist}.
	 * @param ctx the parse tree
	 */
	void exitIdlist(psythonParser.IdlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(psythonParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(psythonParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#truth_val}.
	 * @param ctx the parse tree
	 */
	void enterTruth_val(psythonParser.Truth_valContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#truth_val}.
	 * @param ctx the parse tree
	 */
	void exitTruth_val(psythonParser.Truth_valContext ctx);
	/**
	 * Enter a parse tree produced by {@link psythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(psythonParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link psythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(psythonParser.LiteralContext ctx);
}