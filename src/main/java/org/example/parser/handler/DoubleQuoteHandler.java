package org.example.parser.handler;

public class DoubleQuoteHandler extends Handler {
    private boolean isInsideText;

    DoubleQuoteHandler(char symbol, boolean isInsideText) {
        super(symbol);
        this.isInsideText = isInsideText;
    }

    @Override
    public void process() {
        buffer.append(handledSymbol);
    }
}
