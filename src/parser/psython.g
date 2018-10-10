grammar psython;

options {
  language = Java;
}

@lexer::header {
package parser.output;
}


@parser::header {
package parser.output;
}

program :	 explist
	;

explist :	tabs expression explist
	|	endls explist
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

function_call 
	:	ID '(' arglist ')'
	;

literal
	:	STRING
	|	CHAR
	|	INT
	|	BOOL
	;

return_cmp 	:	'return' arglist
	;
	
argument 
	:	ID | literal
	;
	
arglist :	',' arglist
	|	argument arglist
	|
	;

idlist 	:	',' idlist
	|	ID idlist
	|
	;

function 
	:	tabs 'def' ID '(' idlist ')' ':' endls
		explist
		tabs return_cmp
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
	:	(ID | BOOL | relational) ('and' | 'or') (ID | BOOL | relational)
	|	'not' (ID | BOOL | relational)
	;
	
print	:	'print' argument
	;
	
if_then_else
	:	'if' truth_val ':' endls explist
		(tabs 'elif' truth_val ':' endls explist)*
		(tabs 'else' ':' endls explist)?
		tabs PASS
	;
	
while_exp	:	'while' truth_val ':' endls
		explist
		tabs PASS
	;

truth_val 
	:	ID
	|	BOOL
	| 	relational
	|	logical
	;

PASS 	:	'pass'
	;

BOOL 	:	'True' | 'False'
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

WS  :   ( ' '
        // | '\t'
        | '\r'
        // | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

TAB 	:	'\t'
	;
    	
tabs	:	TAB*
	;

ENDL 	:	'\n'
	;

endls 	:	ENDL+
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
