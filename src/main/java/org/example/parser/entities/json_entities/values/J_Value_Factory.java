package org.example.parser.entities.json_entities.values;

import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.values.impl.J_Boolean;
import org.example.parser.entities.json_entities.values.impl.J_Null;
import org.example.parser.entities.json_entities.values.impl.J_Number;
import org.example.parser.entities.json_entities.values.impl.J_String;

import java.text.NumberFormat;
import java.text.ParseException;

public class J_Value_Factory {
    private static J_Value_Factory instance;

    private J_Value_Factory() {
    }

    public static J_Value_Factory getInstance() {
        if (instance == null) return new J_Value_Factory();
        else return instance;
    }

    public J_Value createAppropriateValue(String content) {
        try {
            Number number = NumberFormat.getInstance().parse(content);
            return new J_Number(number);
        } catch (ParseException e) {
            switch (content) {
                case ("null"):
                    return new J_Null(content);
                case ("true"):
                case ("false"):
                    return new J_Boolean(content);
                default:
                    return new J_String(content);
            }
        }
    }
}
