package org.example.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.net.URL;
import java.util.Properties;

@WebServlet(name = "ExampleServlet", value = "/example")
public class ExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder exampleString = new StringBuilder();
        InputStream data = ExampleServlet.class.getResourceAsStream("/example.json");
        InputStreamReader propertyReader = new InputStreamReader(data);
        BufferedReader bufferedReader = new BufferedReader(propertyReader);
        while (bufferedReader.ready()) {
            exampleString.append(bufferedReader.readLine()).append(System.lineSeparator());
        }
        PrintWriter output = response.getWriter();
        response.setContentType("text/plain");
        output.print(exampleString.toString());
        output.flush();
    }
}
