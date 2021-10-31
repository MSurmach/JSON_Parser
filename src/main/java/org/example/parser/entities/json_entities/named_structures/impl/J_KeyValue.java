package org.example.parser.entities.json_entities.named_structures.impl;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.NamedEntity;
import org.example.parser.entities.json_entities.values.J_Value;
import org.example.parser.exceptions.HierarchyViolation;
import org.example.parser.output.FormattingTemplate;

public class J_KeyValue extends NamedEntity {

    private J_Value value;

    public J_KeyValue(String name) {
        super(name);
    }

    @Override
    public void include(Entity entity) throws HierarchyViolation {
        if (entity instanceof J_Value) {
            value = (J_Value) entity;
        } else {
            String message = "The \"KeyValue\" structure supports only \"Value\" entity attachment. The hierarchy is violated";
            throw new HierarchyViolation(message);
        }
    }

    @Override
    public String toString(FormattingTemplate template, int spacesCount) {
        return String.valueOf(Token.SPACE).repeat(spacesCount) + toString();
    }

    @Override
    public String toString() {
        return name + Token.COLON + Token.SPACE + value;
    }
}
