package de.fhswf.compilerbau;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import de.fhswf.compilerbau.scanner.ColumnRowSourcePosition;
import de.fhswf.compilerbau.scanner.StringToSourceCodeProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StringToSourceCodeProviderTest {


    private StringToSourceCodeProvider stringToSourceCodeProvider;

    @BeforeEach
    void setUp() {
        stringToSourceCodeProvider = new StringToSourceCodeProvider("foo");
    }

    @Test
    void getNextChar() {
        assertThat(stringToSourceCodeProvider.getNextChar(), is('f'));
        assertThat(stringToSourceCodeProvider.getNextChar(), is('o'));
        assertThat(stringToSourceCodeProvider.getNextChar(), is('o'));
        assertThat(stringToSourceCodeProvider.getNextChar(), is(StringToSourceCodeProvider.EOF));
    }

    @Test
    void setAndResetToMarker() {
        stringToSourceCodeProvider.setMarker();
        assertThat(stringToSourceCodeProvider.getNextChar(), is('f'));
        stringToSourceCodeProvider.resetToMarker();
        assertThat(stringToSourceCodeProvider.getNextChar(), is('f'));

        for (int i = 0; i < 4; i++) {
            stringToSourceCodeProvider.getNextChar();
        }

        stringToSourceCodeProvider.resetToMarker();
        assertThat(stringToSourceCodeProvider.getNextChar(), is('f'));
    }

    @Test
    void getCurrentPosition() {
        assertThat(stringToSourceCodeProvider.getCurrentPosition(), is(new ColumnRowSourcePosition(1, 1)));
        stringToSourceCodeProvider.getNextChar();
        assertThat(stringToSourceCodeProvider.getCurrentPosition(), is(new ColumnRowSourcePosition(1, 2)));
    }

    @Test
    void getNextPosition() {
        assertThat(stringToSourceCodeProvider.getNextPosition(), is(new ColumnRowSourcePosition(1, 2)));
        stringToSourceCodeProvider.getNextChar();
        assertThat(stringToSourceCodeProvider.getNextPosition(), is(new ColumnRowSourcePosition(1, 3)));
    }
}