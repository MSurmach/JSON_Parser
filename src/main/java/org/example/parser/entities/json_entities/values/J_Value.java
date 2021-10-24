package org.example.parser.entities.json_entities.values;

import org.example.parser.entities.json_entities.Entity;
import org.example.parser.exceptions.HierarchyViolation;

public abstract class J_Value implements Entity {
    @Override
    public void include(Entity entity) throws HierarchyViolation {
        String message = "Unable to include any attachments to the \"Value\" structure. The hierarchy is violated";
        throw new HierarchyViolation(message);
    }
}
