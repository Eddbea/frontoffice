package com.directmedia.onlinestore.frontoffice.controller;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>OnlineStore, votre boutique multimedia en ligne</h1></body></html>");
        out.println("<a href=\"catalogue\">Accès au catalogue des oeuvres</a>");
        out.println("</body></html>");
    }
}