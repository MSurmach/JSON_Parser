package org.example;

import org.example.parser.Token;
import org.example.parser.entities.json_entities.Entity;

import java.util.ArrayList;

public class Printer {

    public static void printToConsoleParsedJson(ArrayList<Entity> json_entities) {
        System.out.println("Parsed json is here:");
        for (Entity entity :
                json_entities) {
            System.out.print(entity);
            if (json_entities.size() > 1) System.out.println(Token.COMMA);
        }
    }
}
