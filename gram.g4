grammar gram;
/* Parser Rules */
program:
    ((query | command) WS*)* EOF
    ;
// query rules
query:
    relation_name POINTER WS* expr
    ;
expr:
    'SELECT' WS* (condition) WS* expr* //Selection
    | 'PROJECT' WS*  (attribute_list) WS* expr* // Projection
    | 'RENAME' WS* (attribute_list) WS* expr* // Renaming
    | '+' WS* expr // Union
    | '-' WS* expr // Difference
    | '*' WS* expr // Product
    | expr WS* '&' WS* expr // Natural Join
    ;
// DB Editor rules
command:
    open_cmd
    | close_cmd
    | write_cmd
    | exit_cmd
    | show_cmd
    | create_cmd
    | update_cmd
    | insert_cmd
    | delete_cmd
    ;
open_cmd:
    'OPEN' WS* relation_name
    ;
close_cmd:
    'CLOSE' WS* relation_name
    ;
write_cmd:
    'WRITE' WS* relation_name
    ;
exit_cmd:
    'EXIT' WS*
    ;
show_cmd:
    'SHOW' WS* relation_name
    ;
create_cmd:
    'CREATE TABLE' WS* relation_name WS* typed_attr_list
        WS* 'PRIMARY KEY' WS* attribute_list
    ;
update_cmd:
    'UPDATE' WS* relation_name WS* 'SET' WS* attribute_name
        WS* '=' WS* literal (',' attribute_name WS* '=' WS* literal)*
        WS* 'WHERE' WS* condition
    ;
insert_cmd:
    ('INSERT INTO' WS* relation_name)
    (WS* 'VALUES FROM' WS* literal (',' literal)*
    | WS* 'VALUES FROM RELATION' WS* expr
    )
    ;
delete_cmd:
    'DELETE FROM' WS* relation_name WS* 'WHERE' WS* condition
    ;
// Helper rules
identifier:
    (ALPHA | '_') (ALPHA | DIGIT | '_')*
    ;
relation_name:
    identifier
    ;
condition:
    comparison
    ( '||' condition
    | '&&' condition
    )*
    | WS* '*' WS*
    ;
comparison:
    operand OP operand
    ;
operand:
    attribute_name | literal
    ;
attribute_name:
    identifier
    ;
attribute_list:
    attribute_name (',' attribute_name)*
    ;
literal:
    identifier | INTEGER
    ;
typed_attr_list:
    attribute_name type (',' attribute_name type)*
    ;
type:
    WS* ('VARCHAR ' INTEGER | 'INTEGER')
    ;

/* Lex Rules */
ALPHA:
    'a'..'z' | 'A'..'Z'
    ;
DIGIT:
    '0'..'9'
    ;
INTEGER:
    DIGIT+
    ;
OP:
    WS* ('==' | '!=' | '<' | '>' | '<=' | '>=') WS*
    ;
WS: // Whitespace Handler
    (' ' | '\r' | '\n' | '\t')+
    ;
POINTER:
    WS* '<-'
    ;