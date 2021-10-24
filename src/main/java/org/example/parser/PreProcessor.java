package org.example.parser;

import java.util.Arrays;
import java.util.List;

public class PreProcessor {

    private TextNavigator navigator;
    private List<Character> deletableSymbols;

    public PreProcessor(String processable) {
        navigator = new TextNavigator(processable);
        deletableSymbols = Arrays.asList(Token.SPACE, Token.FORM_FEED, Token.LINE_FEED, Token.CARRIAGE_RETURN, Token.BACKSPACE, Token.TABULATION);
    }

    public String preProcess() {
        StringBuilder buffer = new StringBuilder();
        while (navigator.hasSymbol()) {
            char current = navigator.getCurrentSymbol();
            if (current == Token.DOUBLE_QUOTES && !navigator.isEscapedSymbol())
                navigator.setInsideText(!navigator.isInsideText());
            if (deletableSymbols.contains(current)) {
                if (navigator.isInsideText()) buffer.append(current);
            } else buffer.append(current);
            navigator.toNext();
        }
        return buffer.toString();
    }
}
