package org.example.parser.entities.json_entities.named_structures;

import org.example.parser.entities.json_entities.Entity;

public abstract class NamedEntity implements Entity {
    protected String name;

    public NamedEntity(String name) {
        this.name = name;
    }
}
