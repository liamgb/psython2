grammar psython;

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
    .indent(psythonParser.INDENT)
    .dedent(psythonParser.DEDENT)
    .pullToken(psythonLexer.super::nextToken);

  @Override
  public Token nextToken() {
    return denter.nextToken();
  }
}

program
    :	 explist EOF
	;

explist
    :	expression explist
	|	NL explist
	|
	;

expression
	:	function_call
    	| 	assignment
    	| 	function
    	|	arithmetic
    	|	relational
    	| 	logical
    	| 	print
    	| 	if_then_else
    	|	while_exp
    	;

return_cmp
    :	RETURN arglist
	;

function
	:	DEF ID '(' idlist ')' ':'
		INDENT explist (NL|)
		return_cmp NL
		DEDENT
	;

function_call
	:	ID '(' arglist ')'
	;

assignment
	:	idlist '=' (ID | literal | arithmetic | relational | logical | function_call)
	;

arithmetic
	:	(ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
	;

relational
	:	(ID | INT) ('>' | '>=' | '==' | '<' | '<=') (ID | INT)
	;

logical
	:	(ID | BOOL | relational) (AND | OR) (ID | BOOL | relational)
	|	NOT (ID | BOOL | relational)
	;

print	:	PRINT argument
	;

if_then_else
	:	IF truth_val ':'
	        INDENT explist DEDENT
		(ELIF truth_val ':'
		    INDENT explist DEDENT)*
		(ELSE ':'
		    INDENT explist DEDENT)?
	;

while_exp	:	WHILE truth_val ':'
		INDENT explist DEDENT
	;

argument
	:	ID | literal
	;

idlist 	:	',' idlist
	|	ID idlist
	|
	;

arglist :	',' arglist
	|	argument arglist
	|
	;

truth_val
	:	ID
	|	BOOL
	| 	relational
	|	logical
	;

literal
    :	STRING
    |	CHAR
    |	INT
    |	BOOL
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
//WS  :   ( ' '
////         | '\t'
////         | '\r'
////         | '\n'
//        ) -> channel(HIDDEN)
//    ;

COMMENT
    :   ( '#' ~[\r\n]* '\r'? '\n') -> skip
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
