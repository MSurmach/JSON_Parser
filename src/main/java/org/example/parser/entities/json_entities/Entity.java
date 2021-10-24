package org.example.parser.entities.json_entities;

import org.example.parser.exceptions.HierarchyViolation;

public interface Entity {
    public void include(Entity entity) throws HierarchyViolation;
}
