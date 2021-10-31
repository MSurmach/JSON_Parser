package org.example;

import org.example.parser.JSON_Parser;
import org.example.parser.entities.json_entities.Entity;

import java.util.ArrayList;

public class DemoTest {
    public static void main(String[] args) throws Exception {
        String test = "{\"store\":{\"book\":[{\"category\":\"reference\",\"author\":\"Nigel Rees\",\"title\":\"Sayings of the Century\",\"price\":8.95},{\"category\":\"fiction\",\"author\":\"Evelyn Waugh\",\"title\":\"Sword of Honour\",\"price\":12.99},{\"category\":\"fiction\",\"author\":\"J. R. R. Tolkien\",\"title\":\"The Lord of the Rings\",\"isbn\":\"0-395-19395-8\",\"price\":22.99}],\"bicycle\":{\"color\":\"red\",\"price\":19.95}}}";
        JSON_Parser parser = new JSON_Parser(test);
        ArrayList<Entity> result = parser.parse().getListOfEntities();
        Printer.printToConsoleParsedJson(result);
    }
}
