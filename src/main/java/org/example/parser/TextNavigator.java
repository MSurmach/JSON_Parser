package org.example.parser;

/**
 * Navigation through the JSON text;
 */
public class TextNavigator {
    private char[] symbols;
    private int pointer;
    private boolean isInsideText;

    /**
     * Initialization of JsonNavigator object. Splits a json text, which is represented as a string, into char symbols;
     *
     * @param json_text - string content of JSON
     */
    public TextNavigator(String json_text) {
        symbols = json_text.toCharArray();
    }

    public boolean isInsideText() {
        return isInsideText;
    }

    public void setInsideText(boolean insideText) {
        this.isInsideText = insideText;
    }

    public boolean hasSymbol(){
        return pointer!=symbols.length;
    }

    /**
     * Returns the next symbol and shift pointer to the next position (symbol);
     *
     * @return the next symbol from array;
     */
    public void toNext() {
        pointer += 1;
    }

    public char lookAtNextSymbol() {
        return symbols[pointer + 1];
    }

    public char getCurrentSymbol() {
        return symbols[pointer];
    }

    public boolean isEscapedSymbol() {
        if (pointer == 0) return false;
        return symbols[pointer - 1] == Token.REVERSE_SOLIDUS;
    }
}
