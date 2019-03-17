package de.fhswf.compilerbau;

public interface SourceCodeProvider {
    char getNextChar();
    void setMarker();
    void resetToMarker();
    SourcePosition getCurrentPosition();
    SourcePosition getNextPosition();
}