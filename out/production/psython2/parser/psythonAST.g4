grammar psythonAST;

tokens { INDENT, DEDENT }

options
{
    language = Java;
}

@lexer::header {
import helper.*;
import ast.expression.*;
}

@parser::header {
import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;
}

@lexer::members {
  private final DenterHelper denter = DenterHelper.builder()
    .nl(NL)
    .indent(psythonASTParser.INDENT)
    .dedent(psythonASTParser.DEDENT)
    .pullToken(psythonASTLexer.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}

program returns [ExpressionList result = new ExpressionList()]
    :	 el=explist EOF {
        $result = $el.result;
    }
	;

explist returns [ExpressionList result = new ExpressionList()]
    :	exp=expression el=explist {
    	$result = $el.result;
    	$result.insert_expression($exp.result);
    }
	|	NL el=explist {
	    $result = $el.result;
	}
	|
	;

expression returns [Expression result = null]
    :   fc=function_call {
        $result = $fc.result;
    }
    |   asg=assignment {
        $result = $asg.result;
    }
    |   fn=function {
        $result = $fn.result;
    }
    |   ari=arithmetic {
        $result = $ari.result;
    }
    |   rel=relational {
        $result = $rel.result;
    }
    |   lgc=logical {
        $result = $lgc.result;
    }
    |   prt=print {
        $result = $prt.result;
    }
    |   ife=if_then_else {
        $result = $ife.result;
    }
    |   whl=while_exp {
        $result = $whl.result;
    }
    ;

return_cmp returns [ReturnCmp result = null]
    :	RETURN a=argument {
        $result = new ReturnCmp($a.result);
    }
	;

function returns [FunctionExp result = null]
	:	DEF fid=ID '(' argl=idlist ')' ':'
		INDENT fbd=explist (NL|)
		ret=return_cmp NL
		DEDENT{
		    IdentifierNode f_name = new IdentifierNode($fid.text);
		    $result = new FunctionExp(f_name, $argl.result,
                                     $fbd.result, $ret.result);
        }
	;

function_call returns [FunctionCallExp result = null]
	:	id=ID '(' al=arglist ')' {
	    $result = new FunctionCallExp(new IdentifierNode($id.text), $al.result);
	}
	;

assignment returns [AssignmentExp result=null]
    :   i=ID '=' v=value_holder {
    	$result = new AssignmentExp(new IdentifierNode($i.text), $v.result);
    }
    ;

arithmetic returns [ArithmeticExp result = null]
	:	lhs=computable o=ARITH_OPT rhs=computable {
        $result = new ArithmeticExp($lhs.result, $rhs.result, $o.text);
	}
	;

relational returns [RelationalExp result = null]
	:	lhs=computable o=REL_OPT rhs=computable {
        $result = new RelationalExp($lhs.result, $rhs.result, $o.text);
    }
    ;

logical returns [LogicalExp result = null]
	:	lhs=primitive_truth o=(AND | OR) rhs=primitive_truth {
	    $result = new LogicalExp($lhs.result, $rhs.result, $o.text);
	}
	|	o=NOT lhs=primitive_truth {
	    $result = new LogicalExp($lhs.result, $o.text);
	}
	;

print returns [PrintExp result = null]
    :	PRINT a=arglist {
        $result = new PrintExp($a.result);
    }
	;

if_then_else returns [IfThenElseExp result = null]
	:	IF ifcond=truth_val ':'
	        INDENT ifbd=explist DEDENT{
	            $result = new IfThenElseExp($ifcond.result, $ifbd.result);
            }
		(ELIF elifcond=truth_val ':'
		    INDENT elifbd=explist DEDENT{
                $result.create_elif_statement($elifcond.result, $elifbd.result);
		})*
		(ELSE ':'
		    INDENT elsebd=explist DEDENT{
		        $result.create_else_body($elsebd.result);
		})?
	;

while_exp returns [WhileExp result = null]
    :	WHILE tv=truth_val ':'
		INDENT el=explist DEDENT {
		$result = new WhileExp($tv.result, $el.result);
    }
	;

computable returns [Computable result=null]
    :   id=ID {
        $result = new IdentifierNode($id.text);
    }
    |   i=INT {
        $result = new IntNode($i.text);
    }
    ;

value_holder returns [ValueHolder result=null]
    :	id=ID {
    	$result = new IdentifierNode($id.text);
    }
    |	lit=literal {
    	$result = $lit.result;
    }
    |	ari=arithmetic {
    	$result = $ari.result;
    }
    |	rel=relational{
    	$result = $rel.result;
    }
    |	l=logical{
    	$result = $l.result;
    }
    |	func=function_call{
    	$result = $func.result;
    }
    ;

argument returns [Argument result = null]
	:	id=ID {
	    $result = new IdentifierNode($id.text);
	}
	|   lit=literal {
	    $result = $lit.result;
	}
	;

idlist returns [List<IdentifierNode> result = new ArrayList<IdentifierNode>()]
    :	',' idl=idlist {
        $result = $idl.result;
    }
	|	id=ID idl=idlist {
	    $result = $idl.result;
	    $idl.result.add(0, new IdentifierNode($id.text));
	}
	|
	;

arglist returns [List<Argument> result = new ArrayList<Argument>()]
    :	',' al=arglist{
        $result = $al.result;
    }
	|	arg=argument al=arglist {
	    $result = $al.result;
	    $al.result.add(0, $arg.result);
	}
	|
	;

primitive_truth returns [PrimitiveTruth result = null]
    :   id=ID {
        $result = new IdentifierNode($id.text);
    }
    |   bl=BOOL {
        $result = new BoolNode($bl.text);
    }
    |   rel=relational {
        $result = $rel.result;
    }
    ;

truth_val returns [TruthValueHolder result = null]
    :   id=ID {
        $result = new IdentifierNode($id.text);
    }
    |   bl=BOOL {
        $result = new BoolNode($bl.text);
    }
    |   rel=relational {
        $result = $rel.result;
    }
    |   lgc=logical {
        $result = $lgc.result;
    }
    ;

literal returns [Literal result = null]
    :   str=STRING {
    	$result = new StringNode($str.text);
    }
    |   chr=CHAR {
    	$result = new CharNode($chr.text);
    }
    |   i=INT {
    	$result = new IntNode($i.text);
    }
    |   b=BOOL {
    	$result = new BoolNode($b.text);
    }
    ;

ARITH_OPT: ('+' | '-' | '*' | '/')
    ;

REL_OPT: ('>' | '>=' | '==' | '<' | '<=')
    ;

BOOL:	TRUE | FALSE
	;

IF : 'if';
ELIF : 'elif';
ELSE : 'else' ;
RETURN : 'return' ;
DEF : 'def' ;
WHILE: 'while' ;
PRINT: 'print' ;
TRUE: 'True' ;
FALSE: 'False' ;
AND: 'and' ;
OR: 'or' ;
NOT: 'not';

//keyword
//    : IF | ELIF | ELSE | RETURN | DEF | WHILE | PRINT | TRUE | FALSE | AND | OR | NOT
//    ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

NL  : ('\r'? '\n'+ ' '*)
    ;

INT :	'0'..'9'+
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

WS: [ \t]+ -> skip;

COMMENT
    :   '#' ~[\r\n]* -> skip
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
