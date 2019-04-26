# Selbsttestaufgaben 4

## 4.10
### Regeln
Statement → UIfStatement | NStatement  
UIfStatement → "if" "(" Expression ")" Statement
NStatement → "if" "(" Expression ")" NStatement "else" Statement
### Ableitung
**Statement** →  
**UIfStatement** →  
"if" "(" Expression ")" **Statement** →  
"if" "(" Expression ")" **NStatement** →  
"if" "(" Expression ")" "if" "(" Expression ")" NStatement "else" Statement

## 4.11
Assign = Bezeichner "=" Assign | Expr;

## 4.12
Atom = (  
    // ...  
    ArrayDeclaration,
)  // ...   

Initializer = Expr | ArrayInitializer  
ArrayInitializer = "{" Expr {"," Expr} "}";

AttrDecl = ["private" | "public"] VariableDecl;  
VariableDecl = Type Identifier [ "=" Initializer]";";  
