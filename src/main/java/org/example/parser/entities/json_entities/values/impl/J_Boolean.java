package org.example.parser.entities.json_entities.values.impl;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.values.J_Value;
import org.example.parser.output.FormattingTemplate;

public class J_Boolean extends J_Value {
    private final Boolean value;

    public J_Boolean(String value) {
        this.value = Boolean.valueOf(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String toString(FormattingTemplate template, int spacesCount) {
        return String.valueOf(Token.SPACE).repeat(spacesCount)+toString();
    }
}
