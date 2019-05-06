# Selbsttestaufgaben

## 5.1

```java
class Mult extends BinaryOperator {
    public Mult(Node left, Node right) {
        super(left, right);
    }
}
class Int extends Atom {
    public Int(Token token) {
        super(token);
    }
}
```

## 5.2

```java
void exprList() {
    switch(getToken(0)) {
        case PlusSymbol:
        case MinusSymbol:
            matchToken();
            prod();
            exprList();
            break;
        default:
            // ε
            break;
    }
}
void expr() {
    prod();
    exprList();
}
```

## 5.3
Prod → Prod "*" Expo | Prod "/" Expo | Prod "%" Expo | Expo  

ProdList -> Expo "*" ProdList | Expo "/" ProdList | Expo "%" ProdList | ε
Prod -> Expo ProdList  

## 5.4
```java
void prodList(Node left) {
    switch(getToken(0)) {
        case MultiplySymbol:
            matchToken();
            Node newLeft = new Mul(left, expo());
            return prodList(newLeft);
        case DivideSymbol:
            matchToken();
            Node newLeft = new Div(left, expo());
            return prodList(newLeft);
        case ModuloSymbol:
            matchToken();
            Node newLeft = new Mod(left, expo());
            return prodList(newLeft);
        default:
            // ε
            return left;
    }
}
Node prod() {
    Node left = expo();
    return prodList(left);
}
```

## 5.5  

First(Sign) =  
First(Sign →"!"  Sign) ∪ First(Sign →"+" Sign) ∪ First(Sign →"-" Sign) ∪ First(Sign → Atom) =  
{"!"} ∪ {"+"} ∪ {"-"} ∪ First(Atom) =  
{"!"} ∪ {"+"} ∪ {"-"} ∪ ({IntegerLiteral} ∪ {DoubleLiteral} ∪ {Bezeichner} ∪ {"("}) =  
{"!", "+", "-", IntegerLiteral, DoubleLiteral, Bezeichner, "("}) =  