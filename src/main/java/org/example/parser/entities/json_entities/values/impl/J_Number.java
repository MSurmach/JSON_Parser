package org.example.parser.entities.json_entities.values.impl;

import org.example.parser.entities.json_entities.values.J_Value;
import org.example.parser.output.FormattingTemplate;

public class J_Number extends J_Value {
    private final Number value;

    public J_Number(Number value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String toString(FormattingTemplate template) {
        return toString();
    }

}
