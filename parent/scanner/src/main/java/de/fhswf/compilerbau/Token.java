package de.fhswf.compilerbau;

class Token {
    enum Type { EOF, ERROR };
    Type type;
    String content;
    SourcePosition startPosition;
    SourcePosition endPosition;
}
