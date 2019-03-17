package de.fhswf.compilerbau.scanner;

public class StringToSourceCodeProvider implements SourceCodeProvider {

    public static final char EOF = '\0';

    private String string;
    private int index = 0;
    private int marker;

    StringToSourceCodeProvider(String string) {
        this.string = string;
    }

    @Override
    public char getNextChar() {
        if(index < string.length()) {
            char c = string.charAt(index);
            index++;
            return c;
        }
        return EOF;
    }

    @Override
    public void setMarker() {
        marker = index;
    }

    @Override
    public void resetToMarker() {
        index = marker;
    }

    @Override
    public ColumnRowSourcePosition getCurrentPosition() {
        return new ColumnRowSourcePosition(1, index + 1);
    }

    @Override
    public ColumnRowSourcePosition getNextPosition() {
        return new ColumnRowSourcePosition(1, index + 2);
    }
}
