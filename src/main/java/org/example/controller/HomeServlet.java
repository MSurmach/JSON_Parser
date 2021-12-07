package org.example.controller;

import org.example.repository.AppRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {
    private AppRepository appRepository = new AppRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listOfModels", appRepository.getAllModels());
        RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/pages/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
