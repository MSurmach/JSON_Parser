package org.example.parser.handler;

class DefaultHandler extends Handler {

    DefaultHandler(char handledSymbol) {
        super(handledSymbol);
    }

    @Override
    public void process() {
        buffer.append(handledSymbol);
    }
}
