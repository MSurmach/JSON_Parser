package org.example.parser.entities.json_entities.named_structures.impl;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.NamedEntity;
import org.example.parser.exceptions.HierarchyViolation;

import java.util.ArrayList;

public class J_Object extends NamedEntity {

    private final ArrayList<Entity> entities;

    public J_Object(String name) {
        super(name);
        entities = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder nameRepresentation = new StringBuilder();
        if (!name.equals("")) {
            nameRepresentation.append(name).append(Token.COLON).append(Token.SPACE);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 0; counter < entities.size(); counter++) {
            stringBuilder.append(entities.get(counter));
            if (counter != entities.size() - 1) stringBuilder.append(Token.COMMA);
        }
        return nameRepresentation.toString() + Token.LEFT_CURLY_BRACKET + stringBuilder.toString() + Token.RIGHT_CURLY_BRACKET;
    }

    @Override
    public void include(Entity entity) {
        entities.add(entity);
    }
}

