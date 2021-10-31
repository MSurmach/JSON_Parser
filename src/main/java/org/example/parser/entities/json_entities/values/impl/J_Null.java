package org.example.parser.entities.json_entities.values.impl;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.values.J_Value;
import org.example.parser.output.FormattingTemplate;

public class J_Null extends J_Value {
    private final String value;

    public J_Null(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public String toString(FormattingTemplate template,int spacesCount) {
        return String.valueOf(Token.SPACE).repeat(spacesCount)+toString();
    }
}
