import ast.expression.ExpressionList;
import ast.visitor.PrettyPrintVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.psythonASTLexer;
import parser.psythonASTParser;

public class Main {
    public static void main(String[] args) {
        try {
            final ANTLRFileStream afs = new ANTLRFileStream(args[0]);
            final psythonASTLexer psyl = new psythonASTLexer(afs);
            final CommonTokenStream cts = new CommonTokenStream(psyl);
            final psythonASTParser psyp = new psythonASTParser(cts);

            ExpressionList prg = psyp.program().result;

            PrettyPrintVisitor pv = new PrettyPrintVisitor();
            prg.accept(pv);
            System.out.println(pv.result);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
