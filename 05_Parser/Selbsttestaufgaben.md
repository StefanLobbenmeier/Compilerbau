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
        case PLUS_SIGN:
        case MINUS_SIGN:
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

Prod -> Expo ProdList  
ProdList -> Expo "*" ProdList | Expo "/" ProdList | Expo "%" ProdList | ε

