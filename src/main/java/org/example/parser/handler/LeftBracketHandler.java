package org.example.parser.handler;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.impl.J_Array;
import org.example.parser.entities.json_entities.named_structures.impl.J_Object;

public class LeftBracketHandler extends Handler {

    LeftBracketHandler(char handledSymbol) {
        super(handledSymbol);
    }

    @Override
    public void process() {
        String availableName = buffer.toString();
        buffer.setLength(0);
        Entity created = initialize(availableName);
        storage.push(created);
    }

    private Entity initialize(String name) {
        return handledSymbol == Token.LEFT_SQUARE_BRACKET ? new J_Array(name) : new J_Object(name);
    }
}
