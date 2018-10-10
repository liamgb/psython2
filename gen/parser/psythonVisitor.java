// Generated from C:/Users/mocli/Code/psython2/src/parser\psython.g4 by ANTLR 4.7
package parser;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link psythonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface psythonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link psythonParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(psythonParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(psythonParser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(psythonParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#return_cmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_cmp(psythonParser.Return_cmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(psythonParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(psythonParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(psythonParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#arithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(psythonParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(psythonParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(psythonParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(psythonParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#if_then_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_then_else(psythonParser.If_then_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#while_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_exp(psythonParser.While_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(psythonParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist(psythonParser.IdlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(psythonParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#truth_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruth_val(psythonParser.Truth_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(psythonParser.LiteralContext ctx);
}