package de.fhswf.compilerbau.scanner;

import java.util.List;

public class Filter extends Scanner {
    List<Token> tokenList;

    @Override
    protected Token getNextToken(int i) {
        return tokenList.get(i);
    }

    boolean matchToken(Token.Type type) {
        final boolean matches = tokenList.get(0).type == type;
        tokenList.remove(0);
        return matches;
    }

    void matchToken() {
        tokenList.remove(0);
    }
}
