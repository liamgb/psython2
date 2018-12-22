package utility;


import ast.expression.ExpressionList;
import ast.visitor.AtomicVisitor;
import ast.visitor.NumberingVisitor;
import ast.visitor.SymbolTableVisitor;
import cesk.State;
import cesk.SymbolTable;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.psythonASTLexer;
import parser.psythonASTParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Builder {
    public static ExpressionList ast_builder(String filename, int expected) {
        ExpressionList prg = null;
        try {
            final ANTLRFileStream afs = new ANTLRFileStream(filename);
            final psythonASTLexer psyl = new psythonASTLexer(afs);
            final CommonTokenStream cts = new CommonTokenStream(psyl);
            final psythonASTParser psyp = new psythonASTParser(cts);

            // AST building
            prg = psyp.program().result;
            assertTrue(psyp.getNumberOfSyntaxErrors() == expected);

        } catch (final Exception e) {
            e.printStackTrace();
//			assertTrue(e.getMessage(), false);
        } finally {
            return prg;
        }
    }

    public static SymbolTable symtab_builder(ExpressionList program) {
        SymbolTableVisitor stv = null;
        try {
            // 2 passes symbol table building
            stv = new SymbolTableVisitor();
            program.accept(stv);
            stv = new SymbolTableVisitor(stv.result);
            program.accept(stv);

            if (stv.result.check_undefined()) {
                System.out.println("Exist defined variables:");
                System.out.println(stv.result);
                assert false;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            return stv.result;
        }
    }

    public static List<ExpressionList> numbering(ExpressionList program) {
        NumberingVisitor nv = null;

        try {
            nv = new NumberingVisitor();
            program.accept(nv);
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            return nv.program_strut;
        }
    }

    public static void build_atomic_exe(ExpressionList program, boolean side_eff) {
        try {
            AtomicVisitor av = new AtomicVisitor(side_eff);
            program.accept(av);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static State preprocessor(String filename, int expected, boolean side_eff) {
        ExpressionList program = ast_builder(filename, expected);
        SymbolTable st = symtab_builder(program);
        build_atomic_exe(program, side_eff);

        return new State(st);
    }
}
