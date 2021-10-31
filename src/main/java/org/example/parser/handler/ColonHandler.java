package org.example.parser.handler;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.impl.J_KeyValue;

public class ColonHandler extends Handler {
    private final char nextSymbol;

    public ColonHandler(char symbol, char next) {
        super(symbol);
        nextSymbol = next;
    }

    @Override
    public void process() {
        if (nextSymbol != Token.LEFT_SQUARE_BRACKET && nextSymbol != Token.LEFT_SQUARE_BRACKET) {
            String name = buffer.toString();
            Entity likeAFieldEntity = new J_KeyValue(name);
            buffer.setLength(0);
            storage.push(likeAFieldEntity);
        }
    }
}
