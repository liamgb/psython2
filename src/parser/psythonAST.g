grammar psythonAST;

options {
  language = Java;
}

@lexer::header {
package parser.output;
}

@parser::header {
package parser.output;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;
}

program returns [ExpressionList result = null]
    :    prg = explist[0] {
    	result = $prg.result;
    }
    ;

explist [int indent_lvl] returns [ExpressionList result = new ExpressionList(indent_lvl)]
    :   t=tabs exp=expression[$indent_lvl] el=explist[$indent_lvl] {
    	result = $el.result;
    	result.insert_expression($exp.result, $t.result);
    }
    |   endls el=explist[$indent_lvl] {
    	result = $el.result;
    }
    |
    ;

expression [int indent_lvl] returns [Expression result = null]
    :   fc=function_call {
        result = $fc.result;
    }
    |   asg=assignment {
        result = $asg.result;
    }
    |   fn=function[$indent_lvl] {
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
    |   ife=if_then_else[$indent_lvl] {
        result = $ife.result;
    }
    |   whl=while_exp[$indent_lvl] {
        result = $whl.result;
    }
    ;

function_call returns [FunctionCallExp result = null]
    :   ID '(' arglist ')'
    ;


return_cmp returns [ReturnCmp result = null]
    :   'return' al=arglist {
    	result = null;
    }
    ;
    
literal returns [Literal result = null]
    :   str=STRING {
    	result = new StringNode($str.text);
    }
    |   chr=CHAR {
    	result = new CharNode($chr.text);
    }
    |   i=INT {
    	result = new IntNode($i.text);
    }
    |   b=BOOL {
    	result = new BoolNode($b.text);
    }
    ;

    
argument returns [Argument result = null]
    :   ID 
    |   literal
    ;
    
arglist returns [List<Argument> result = null]
    :   ',' al=arglist {
    	//result = $al.result;
    }
    |   arg=argument al=arglist {
    	//result = $al.result;
    	//$al.result.add(0, new IdentifierNode($arg.result));
    }
    |
    ;

idlist returns [List<IdentifierNode> result = new ArrayList<IdentifierNode>()]
    :   ',' idl=idlist {
        result = $idl.result;
    }
    |   id=ID idl=idlist {
    	result = $idl.result;
        $idl.result.add(0, new IdentifierNode($id.text));
    }
    |
    ;

function [int indent_lvl] returns [FunctionExp result = null]
    :   'def' fid=ID '(' argl=idlist ')' ':' endls
        fbd=explist[$indent_lvl + 1]
        t=tabs ret=return_cmp {
        	IdentifierNode f_name = new IdentifierNode($fid.text);
        	result = new FunctionExp( f_name, $argl.result,
                       $fbd.result, $ret.result, $t.result, indent_lvl);
        }
        
    ;

assignment returns [AssignmentExp result=null] 
    :   i=ID '=' v=value_holder {
    	result = new AssignmentExp(new IdentifierNode($i.text), $v.result);
    }
    ;
    
value_holder returns [ValueHolder result=null]
    :	id=ID {
    	result = new IdentifierNode($id.text);
    }
    |	lit=literal {
    	result = $lit.result;
    }
    |	ari=arithmetic {
    	result = $ari.result;
    }
    |	rel=relational{
    	result = $rel.result;
    }
    |	l=logical{
    	result = $l.result;
    }
    |	func=function_call{
    	result = $func.result;
    }
    ;

arithmetic returns [ArithmeticExp result = null]
    :   (ID | INT) ('+' | '-' | '*' | '/') (ID | INT)
    ;

relational returns [RelationalExp result = null]
    :   (ID | INT) ('>' | '>=' | '==' | '<' | '<=') (ID | INT)
    ;

logical returns [LogicalExp result = null]
    :   (ID | BOOL | relational) ('and' | 'or') (ID | BOOL | relational)
    |   'not' (ID | BOOL | relational)
    ;
    
print   returns [PrintExp result = null]
    :   'print' argument
    ;
    
if_then_else [int indent_lvl] returns [IfThenElseExp result = null]
    :   'if' ifcond=truth_val ':' endls ifbd=explist[$indent_lvl + 1] {
    		result = new IfThenElseExp($ifcond.result, $ifbd.result, indent_lvl);
    	}
        (tabs 'elif' elifcond=truth_val ':' endls elifbd=explist[$indent_lvl + 1]{
        	result.create_elif_statement($elifcond.result, $elifbd.result);
        })*
        (tabs 'else' ':' endls elsebd=explist[$indent_lvl + 1] {
        	result.create_else_body($elsebd.result);
        })?
        t=tabs PASS {
        	result.check_pass($t.result);
        }
    ;
    
while_exp [int indent_lvl] returns [WhileExp result = null]
    :   'while' tv=truth_val ':' endls
        el=explist[$indent_lvl + 1]
        t=tabs PASS {
        result = new WhileExp($tv.result, indent_lvl, $el.result, $t.result);
        }
    ;
    
truth_val returns [TruthValueHolder result = null]
    :   id=ID {
    	result = new IdentifierNode($id.text);
    }
    |   bl=BOOL {
    	result = new BoolNode($bl.text);
    }
    |   rel=relational {
    	result = $rel.result;
    }
    |   lgc=logical {
    	result = $lgc.result;
    }
    ;

PASS    :   'pass'
    ;

BOOL    :   'True' | 'False'
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
        
tabs returns [String result=""]
    :   ts=TAB* {
    	result += $ts.text;
    }
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
