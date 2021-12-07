package org.example.controller;

import org.example.model.AppModel;
import org.example.parser.JSON_Parser;
import org.example.parser.entities.json_entities.Entity;
import org.example.repository.AppRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProcessorServlet extends HttpServlet {
    private AppRepository appRepository = new AppRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = request.getParameter("json-input");
        String template = request.getParameter("template");
        String currentDateAndTime = getCurrentTimeAndDate();
        String formattedJSON = null;
        try {
            formattedJSON = getFormattedJsonString(template, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AppModel model = new AppModel();
        model.setDateAndTime(currentDateAndTime);
        model.setFormattedJSONString(formattedJSON);
        appRepository.add(model);
        response.sendRedirect("/home");
    }

    private String getCurrentTimeAndDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy\nHH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTimeFormatter.format(dateTime);
    }

    private String getFormattedJsonString(String template, String unformattedJSON) throws Exception {
        JSON_Parser parser = new JSON_Parser(unformattedJSON);
        return parser.parse().getTemplatedJSONString(template);
    }
}
