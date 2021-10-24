package org.example.parser.entities.json_entities.values.impl;

import org.example.parser.entities.json_entities.values.J_Value;

public class J_String extends J_Value {
    private final String value;

    public J_String(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
