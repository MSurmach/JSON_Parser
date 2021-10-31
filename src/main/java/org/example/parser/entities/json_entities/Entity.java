package org.example.parser.entities.json_entities;

import org.example.parser.exceptions.HierarchyViolation;
import org.example.parser.output.FormattingTemplate;

public interface Entity {
    void include(Entity entity) throws HierarchyViolation;

    String toString(FormattingTemplate template) throws Exception;

}
