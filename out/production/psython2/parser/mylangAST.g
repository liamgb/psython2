grammar mylangAST;

options {
  language = Java;
}

@header {
package mylang.parser;
import mylang.ast.*;
}

program returns [ExpList result = null]
    :    el=explist[0] EOF {
        result = $el.result;
    }
    ;

explist[int intend_lvl] returns [ExpList result = null]
    :	t=tabs exp=expression el=explist[$intend_lvl] {
    	result = $el.result;
    	result.insert_expression($exp, $t);
    }
    |	endls el=explist[$intend_lvl]{
    	result = $el.result;
    }
    | {
    	result = new ExpressionList($intend_lvl);
    }
    ;

expression returns [Expression result = null]
    :   fc=function_call {
        result = $fc.result;
    }
    |   asg=assignment {
        result = $asg.result;
    }
    |   fn=function {
        result = $fn.result;
    }
    |   ari=arithmetic {
        result = $ari.result;
    }
    |   rel=relational {
        result = $rel.result;
    }
    |   lgc=logical {
        result = $lgc.result;
    }
    |   prt=print {
        result = $prt.result;
    }
    |   ife=if_then_else {
        result = $ife.result;
    }
    |   whl=while {
        result = $whl.result;
    }
    ;

function_call returns [Expression result = null]
    :   id=ID '(' al=arglist ')' {
    	func_id = new IdentifierNode($id.text);
        result = new FunctionCallExp(func_id, $al.result);
    }
    ;

literal returns [Literal result = null]
    :   s=STRING {
        result = new StringNode($s.text);
    }
    |   c=CHAR {
        result = new CharNode($c.text);
    }
    |   i=INT {
        result = new IntNode($i.text);
    }
    |   b=BOOL {
        result = new BoolNode($b.text);
    }
    ;

ret returns [ReturnCmp result = null]
    :   'return' al=arglist {
        result = new ReturnCmp($al.result);
    }
    ;

argument returns [Argument result = null]
    :   id=ID {
        result = new IdentifierNode($id.text);
    }
    |   lit=literal {
        result = $lit.result;
    }
    ;

arglist returns [ArgList result = null]
    :   ',' al=arglist {
        result = $al.result
    }
    |   arg=argument al=arglist {
        $al.result.add(0, $arg.result);
    }
    |	{
    	result = new ArrayList<Argument>();
    }
    ;

idlist returns [List<IdentifierNode> result = new ArrayList<IdentifierNode>()]
    :   ',' idlist {
        result = id.result;
    }
    |   id=ID idl=idlist {
        idl.result.add(0, new IdentifierNode(id.text));
    }
    | {
    	result = new ArrayList<IdentifierNode>();
    }
    ;

function [int indent_lvl] returns [FunctionExp result = null]
    :   'def' id=ID '(' idl=idlist ')' ':' endls
        expl=explist[indent_lvl + 1]
        tabs r=ret {
        	id_ob = new IdentifierNode($id.text);
        	result = new FunctionExp($id_ob, $idl.result, 
        		$expl[$indent_lvl + 1].result, $r);
        }
    ;

assignment returns [FunctionExp result = null]
    :   idlist '=' (ID | literal | arithmetic | relational | logical | function_call) {
    	
    }
    ;

arithmetic 
    :   (ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;

relational
    :   (ID | INT) ('>' | '>=' | '==' | '<' | '<=') (ID | INT)
    ;

logical
    :   (ID | BOOL | relational) ('and' | 'or') (ID | BOOL | relational)
    |   'not' (ID | BOOL | relational)
    ;
    
print
    :   'print' argument
    ;

if_then_else
    :   'if' truth_val ':' endls explist
        (tabs 'elif' truth_val ':' endls explist)*
        (tabs 'else' ':' endls explist)?
        tabs PASS
    ;

while
    :   'while' truth_val ':' endls
        explist
        tabs PASS
    ;

truth_val returns [TruthValueHolder result = null]
    :   id=ID {
    	result = new IdentifierNode(id.text);
    }
    |   bl=BOOL {
    	result = new BoolNode(bl.text);
    }
    |   rel=relational {
    	result = rel.result;
    }
    |   lgc=logical {
    	result = lgc.result;
    }
    ;

PASS
    :   'pass'
    ;

BOOL
    :   'True' | 'False'
    ;

ID  :   ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :   '0'..'9'+
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

TAB     :   '\t'
    ;
        
tabs    :   TAB*
    ;

ENDL    :   '\n'
    ;

endls   :   ENDL+
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
