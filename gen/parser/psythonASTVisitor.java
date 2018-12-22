// Generated from C:/Users/mocli/Code/psython2/src/parser\psythonAST.g4 by ANTLR 4.7
package parser;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;
import ast.wrapper.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link psythonASTParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface psythonASTVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(psythonASTParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#explist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplist(psythonASTParser.ExplistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(psythonASTParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#return_cmp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_cmp(psythonASTParser.Return_cmpContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(psythonASTParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(psythonASTParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(psythonASTParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#arithmetic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmetic(psythonASTParser.ArithmeticContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(psythonASTParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical(psythonASTParser.LogicalContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(psythonASTParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#next_rand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext_rand(psythonASTParser.Next_randContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#seed_rand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeed_rand(psythonASTParser.Seed_randContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#if_then_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_then_else(psythonASTParser.If_then_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#while_exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_exp(psythonASTParser.While_expContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#computable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputable(psythonASTParser.ComputableContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#value_holder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue_holder(psythonASTParser.Value_holderContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(psythonASTParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#idlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdlist(psythonASTParser.IdlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(psythonASTParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#primitive_truth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_truth(psythonASTParser.Primitive_truthContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#truth_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTruth_val(psythonASTParser.Truth_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link psythonASTParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(psythonASTParser.LiteralContext ctx);
}