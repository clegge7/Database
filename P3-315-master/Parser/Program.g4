
// Define a grammar called Program
grammar Program;

program			: (query|command)* ';' ;

query  			: relationname '<-' expr ;

relationname 	: identifier;	

identifier 		: alpha ((alpha|digit|'_')*) ;

alpha			: 'a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|
				  'n'|'o'|'p'|'q'|'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z'|
				  'A'|'B'|'C'|'D'|'E'|'F'|'G'|'H'|'I'|'J'|'K'|'L'|'M'|
				  'N'|'O'|'P'|'Q'|'R'|'S'|'T'|'U'|'V'|'W'|'X'|'Y'|'Z' ;			//any letter

digit			: '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9' ;					//any number

expr 			: atomicexpr
				 |selection
				 |projection
				 |renaming
				 |union
				 |difference
				 |product
				 |naturaljoin ;

atomicexpr		: relationname | '('expr')';

selection		: 'select' ('('condition')')* atomicexpr* ;

condition		: conjunction ('||'conjunction)* ;

conjunction		: comparison ('&&'comparison)* ;

comparison		: operand op operand | '('condition')' ;

op				: '=='|'!='|'<'|'>'|'<='|'>=' ;

operand			: attributename | literal ;

attributename	: identifier ;

literal			: '"'relationname'"'|integer|;

projection		: 'project' '('attributelist')' atomicexpr ;

attributelist	: attributename (','attributename)* ;

renaming		: 'rename' '('attributelist')' atomicexpr ;

union			: atomicexpr '+' atomicexpr ;

difference		: atomicexpr '-' atomicexpr ;

product			: atomicexpr '*' atomicexpr ;

naturaljoin		: atomicexpr '&' atomicexpr ;

//below is the command aspect of out parser

command			: opencmd|closecmd|writecmd|exitcmd|showcmd|
				  createcmd|updatecmd|insertcmd|deletecmd ;

opencmd			: 'OPEN' relationname ;

closecmd		: 'CLOSE' relationname ;

writecmd		: 'WRITE' relationname ;

exitcmd			: 'EXIT' ;

showcmd			: 'SHOW' atomicexpr ;

createcmd		: 'CREATE TABLE' relationname '('typedatrlist(','typedatrlist)*')' 'PRIMARY KEY' '('attributelist')' ;

updatecmd		: 'UPDATE' relationname 'SET' attributename '=' literal '{'','attributename '=' literal'}'
				  'WHERE' condition ;
				  
insertcmd		: 'INSERT INTO' relationname 'VALUES FROM' '('literal(','literal)*')' | 
				  'INSERT INTO' relationname 'VALUES FROM RELATION' expr ;

deletecmd		: 'DELETE FROM' relationname 'WHERE' condition ;

typedatrlist	: attributename type ('('','attributename type')')* ;

type			: 'VARCHAR' '('integer')' | 'INTEGER' ;

integer			: digit((digit)*) ;

WS 				: [ \t\r\n]+ -> skip ;	 		// skip spaces, tabs, newlines
