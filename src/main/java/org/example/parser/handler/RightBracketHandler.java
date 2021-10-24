package org.example.parser.handler;

public class RightBracketHandler extends Handler {

    RightBracketHandler(char handledSymbol) {
        super(handledSymbol);
    }

    @Override
    public void process() {
        new CommaHandler(handledSymbol).process();
    }
}
