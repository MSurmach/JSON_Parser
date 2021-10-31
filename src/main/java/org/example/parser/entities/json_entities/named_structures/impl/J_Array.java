package org.example.parser.entities.json_entities.named_structures.impl;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.NamedEntity;
import org.example.parser.exceptions.HierarchyViolation;
import org.example.parser.output.FormattingTemplate;

import java.util.ArrayList;

public class J_Array extends NamedEntity {

    private final ArrayList<Entity> entities;


    public J_Array(String name) {
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
        return nameRepresentation.toString() + Token.LEFT_SQUARE_BRACKET + stringBuilder.toString() + Token.RIGHT_SQUARE_BRACKET;
    }

    @Override
    public void include(Entity entity) throws HierarchyViolation {
        if (!(entity instanceof J_KeyValue)) {
            entities.add(entity);
        } else {
            String message = "The \"Array\" structure supports all entity attachment, except the \"KeyValue\" structure. The hierarchy is violated";
            throw new HierarchyViolation(message);
        }
    }

    @Override
    public String toString(FormattingTemplate template) throws Exception {
        switch (template) {
            case SPACED -> {
                return getInSpacedFormat();
            }
            case COMPACT -> {
                return getInCompactFormat();
            }
            default -> {
                throw new Exception("Unsupported formatting template");
            }
        }
    }

    private String getInCompactFormat() {
        StringBuilder nameRepresentation = new StringBuilder();
        if (!name.equals("")) {
            nameRepresentation.append(name).append(Token.COLON).append(Token.SPACE);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 0; counter < entities.size(); counter++) {
            stringBuilder.append(entities.get(counter));
            if (counter != entities.size() - 1) stringBuilder.append(Token.COMMA);
        }
        return nameRepresentation.toString() + Token.LEFT_SQUARE_BRACKET + stringBuilder.toString() + Token.RIGHT_SQUARE_BRACKET;
    }

    private String getInSpacedFormat() {
        StringBuilder nameRepresentation = new StringBuilder();
        if (name.equals("")) {
            nameRepresentation.append(Token.LEFT_SQUARE_BRACKET).append(Token.LINE_FEED);
        } else nameRepresentation.append(name).append(Token.COLON).append(Token.SPACE).append(Token.LEFT_SQUARE_BRACKET).append(Token.LINE_FEED);
        StringBuilder stringBuilder = new StringBuilder();
        for (int counter = 0; counter < entities.size(); counter++) {
            stringBuilder.append(entities.get(counter));
            if (counter != entities.size() - 1) stringBuilder.append(Token.COMMA).append(Token.LINE_FEED);
            else stringBuilder.append(Token.LINE_FEED);
        }
        return nameRepresentation.toString() + stringBuilder.toString() + Token.RIGHT_SQUARE_BRACKET;
    }
}

