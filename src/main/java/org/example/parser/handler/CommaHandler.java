package org.example.parser.handler;

import org.example.parser.entities.json_entities.Entity;
import org.example.parser.entities.json_entities.named_structures.impl.J_KeyValue;
import org.example.parser.entities.json_entities.values.J_Value;
import org.example.parser.entities.json_entities.values.J_Value_Factory;
import org.example.parser.exceptions.HierarchyViolation;

public class CommaHandler extends Handler {

    CommaHandler(char handledSymbol) {
        super(handledSymbol);
    }

    @Override
    public void process() {
        int includeCounter = 1;
        if (buffer.length() != 0) {
            J_Value value = J_Value_Factory.getInstance().createAppropriateValue(buffer.toString());
            if (storage.peek() instanceof J_KeyValue)
                includeCounter += 1;
            storage.push(value);
            buffer.setLength(0);
        }
        while (includeCounter > 0 && storage.size() > 1) {
            Entity topEntity = storage.pop();
            try {
                storage.peek().include(topEntity);
            } catch (HierarchyViolation exception) {
                System.out.println(exception.getMessage());
            }
            includeCounter -= 1;
        }
    }
}
