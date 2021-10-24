package org.example.parser.handler;

import org.example.parser.entities.json_entities.Entity;

import java.util.Stack;

public abstract class Handler {

    protected StringBuilder buffer;
    protected Stack<Entity> storage;
    protected char handledSymbol;

    Handler(char handledSymbol) {
        this.handledSymbol = handledSymbol;
    }

    public abstract void process();

    public Handler setGlobalStorage(Stack<Entity> storage) {
        this.storage = storage;
        return this;
    }

    public Handler setBuffer(StringBuilder textBuffer) {
        buffer = textBuffer;
        return this;
    }
}
