package de.fhswf.compilerbau.scanner;

public interface SourceCodeProvider {
    char getNextChar();
    void setMarker();
    void resetToMarker();
    SourcePosition getCurrentPosition();
    SourcePosition getNextPosition();
}