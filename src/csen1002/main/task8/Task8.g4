/**
 * Write your info here
 *
 * @name Mahmoud Hesham
 * @id 46-5151
 * @labNumber 12
 */

grammar Task8;

temp : 'it is an empty rule';

IF : 'if' | 'If' | 'iF' | 'IF' ;
ELSE : ELSEE ;

LP : '(' ;
RP : ')' ;
COMP : '>' | '<' | '>=' | '<=' | '==' | '!=' ;

ID : (LETTER| '_') (LETTER | DIGIT | '_')* ;
NUM : DIGIT+ ('.' DIGIT+)? (('e'|'E') ('+' | '-')? DIGIT+)? ;
LIT : '"' (LITT | ~('"' | '\\'))* '"' ;
BLANK : [ \t\r\n]+ -> skip ;

fragment LETTER : [a-zA-Z] ;
fragment DIGIT : [0-9] ;
fragment ELSEE options {caseInsensitive=true;}: 'else' ;
fragment LITT : '\\' ('\\' | '"') ;


