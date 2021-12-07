package org.example.parser;

import org.example.parser.handler.Handler;
import org.example.parser.handler.HandlerFactory;
import org.example.parser.entities.json_entities.Entity;
import org.example.parser.output.FormattingTemplate;

import java.util.ArrayList;
import java.util.Stack;

public class JSON_Parser {

    private final TextNavigator NAVIGATOR;
    private final Stack<Entity> STORAGE;
    private final StringBuilder TEXT_BUFFER;

    public JSON_Parser(String json_text) {
        String parseble = new PreProcessor(json_text).preProcess();
        NAVIGATOR = new TextNavigator(parseble);
        STORAGE = new Stack<>();
        TEXT_BUFFER = new StringBuilder();
    }

    public JSON_Parser parse() {
        while (NAVIGATOR.hasSymbol()) {
            Handler handler = HandlerFactory.getInstance().getAppropriateHandler(NAVIGATOR);
            handler.setGlobalStorage(STORAGE).setBuffer(TEXT_BUFFER).process();
            NAVIGATOR.toNext();
        }
        return this;
    }

    public String getTemplatedJSONString(String template) throws Exception {
        FormattingTemplate formattingTemplate = FormattingTemplate.valueOf(template);
        int defaultSpacesCount = 0;
        StringBuilder templatedJSONString = new StringBuilder();
        for (Entity entity :
                getListOfEntities()) {
            templatedJSONString.append(entity.toString(formattingTemplate, defaultSpacesCount));
        }
        return templatedJSONString.toString();
    }

    private ArrayList<Entity> getListOfEntities() {
        return new ArrayList<>(STORAGE);
    }
}
