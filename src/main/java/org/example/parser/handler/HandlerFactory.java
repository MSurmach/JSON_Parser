package org.example.parser.handler;

import org.example.parser.TextNavigator;
import org.example.parser.Token;

public class HandlerFactory {

    private static HandlerFactory instance;

    private HandlerFactory() {
    }

    public static HandlerFactory getInstance() {
        if (instance == null) return new HandlerFactory();
        else return instance;
    }

    // to this I have to add checking. The symbol may be inside text.
    public Handler getAppropriateHandler(TextNavigator navigator) {
        char currentSymbol = navigator.getCurrentSymbol();
        switch (currentSymbol) {
            case Token.DOUBLE_QUOTES:
                return new DoubleQuoteHandler(currentSymbol, navigator.isInsideText());
            case Token.COLON:
                return new ColonHandler(currentSymbol, navigator.lookAtNextSymbol());
            case Token.COMMA:
            case Token.RIGHT_CURLY_BRACKET:
            case Token.RIGHT_SQUARE_BRACKET:
                return new CommaHandler(currentSymbol);
            case Token.LEFT_CURLY_BRACKET:
            case Token.LEFT_SQUARE_BRACKET:
                return new LeftBracketHandler(currentSymbol);
            default:
                return new DefaultHandler(currentSymbol);
        }
    }
}
