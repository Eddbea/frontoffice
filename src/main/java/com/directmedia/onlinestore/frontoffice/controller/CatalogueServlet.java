package com.directmedia.onlinestore.frontoffice.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CatalogueServlet", value = "/catalogue")
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        //out.println("<head>");
        out.println("<body>");
        out.println("<a href=\"https://localhost:8081/frontoffice_war_exploded/catalogue\">Accès au catalogue des oeuvres</a>");
        out.println("</body");
        out.println("</html>");

    }
}