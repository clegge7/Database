
// Define a grammar called Program
grammar Program;

program			: ((query|command) (';' (query|command))* ';'?) | EOF ;

query  			: relationname '<-' expr ;

relationname 	: Identifier;

Type			: 'INTEGER' | 'VARCHAR' '('Integer')' ;

Null			: 'NULL' ;

Integer			: Digit+ ;

Identifier 		: Alpha ((Alpha|Digit|'_')*) ;

Alpha			: [a-zA-Z_] ;			//any letter

Digit			: [0-9] ;					//any number

Varchar			: '"' (~["] | '\\"')+ '"' ;

expr 			: atomicexpr
				 |selection
				 |projection
				 |renaming
				 |union
				 |difference
				 |product
				 |naturaljoin ;

atomicexpr		: relationname | '('expr')';

selection		: 'select' '('condition')' atomicexpr ;

condition		: conjunction ('||'conjunction)* ;

conjunction		: comparison ('&&'comparison)* ;

comparison		: operand op operand | '('condition')' ;

op				: '=='|'!='|'<'|'>'|'<='|'>=' ;

operand			: attributename | literal ;

attributename	: Identifier ;

literal			: Varchar|Integer|Null;

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

createcmd		: 'CREATE TABLE' relationname '(' typedatrlist ')' 'PRIMARY KEY' '(' attributelist ')' ;

updatecmd		: 'UPDATE' relationname 'SET' attributename '=' literal (','attributename '=' literal)*
				  'WHERE' condition ;

insertcmd		: 'INSERT INTO' relationname 'VALUES FROM' '('literal(','literal)*')' |
				  'INSERT INTO' relationname 'VALUES FROM RELATION' expr ;

deletecmd		: 'DELETE FROM' relationname 'WHERE' condition ;

typedatrlist	: attributename Type (',' attributename Type)* ;

WS 				: [ \t\r\n]+ -> skip ;	 		// skip spaces, tabs, newlines
