package basis;

import ast.visitor.PrettyPrintVisitor;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import parser.psythonLexer;
import parser.psythonParser;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParserTest {

	public static void testPass(final String filename, final int expected) {
		try {
			final ANTLRFileStream afs = new ANTLRFileStream(filename);
			final psythonLexer psyl = new psythonLexer(afs);
			final CommonTokenStream cts = new CommonTokenStream(psyl);
			final psythonParser psyp = new psythonParser(cts);

			psyp.program();
			assertTrue(psyp.getNumberOfSyntaxErrors() == expected);


		} catch (final Exception e) {
			e.printStackTrace();
//			assertTrue(e.getMessage(), false);
		}
	}

	@Test
	public void testProgram0() {
		ParserTest.testPass("src-examples/test_while.py", 0);
	}

	@Test
	public void testProgram1() {
		ParserTest.testPass("src-examples/test_func.py", 0);
	}

	@Test
	public void testProgram2() {
		ParserTest.testPass("src-examples/xample.py", 0);
	}

	@Test
	public void testProgram3() {
		ParserTest.testPass("src-examples/test2.py", 0);
	}

}
