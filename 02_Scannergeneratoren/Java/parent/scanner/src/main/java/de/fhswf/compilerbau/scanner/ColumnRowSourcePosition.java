package de.fhswf.compilerbau.scanner;

import java.util.Objects;

public class ColumnRowSourcePosition implements SourcePosition {
    private final int row;
    private final int column;

    public ColumnRowSourcePosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "ColumnRowSourcePosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnRowSourcePosition that = (ColumnRowSourcePosition) o;
        return row == that.row &&
                column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
