package de.fhswf.compilerbau.scanner;

public class Token {
    public enum Type { EOF, ERROR };
    Type type;
    String content;
    SourcePosition startPosition;
    SourcePosition endPosition;
}
