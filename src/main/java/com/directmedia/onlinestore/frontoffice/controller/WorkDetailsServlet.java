package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WorkDetailsServlet", value = "/work-details")
public class WorkDetailsServlet extends HttpServlet {

    /**
     * @param req      an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("id");

        //stream java 8
        //Work work = Catalogue.listOfWorks.stream().filter(workf -> workf.getId()==Long.parseLong(id)).findFirst().get();

        try {
            Work work = new Work();
            for (Work nextWork : Catalogue.listOfWorks) {
                if (nextWork.getId() == Long.parseLong(id)) {
                    work = nextWork;
                    break;
                }
            }
            PrintWriter out = response.getWriter();
            out.print("<html><body><h1>Descriptif de l'oeuvre</h1><BR/>");
            out.print("Titre: " + work.getTitle() + "<BR/>");
            out.print("Annee de parution: " + work.getRelease() + "<BR/>");
            out.print("Genre: " + work.getGenre() + "<BR/>");
            out.print("Artiste: " + work.getMainArtist().getName() + "<BR/>");
            out.print("Resume: " + work.getSummary() + "<BR/>");
            out.print("<form action=\"addToCart\" method=\"POST\">");
            out.print("<INPUT type=\"hidden\" name=\"identifiant\" value=\""+work.getId()+"\"/>");
            out.print("<INPUT type=\"submit\" value=\"Ajouter au caddie\"/>");
            out.print("</form></body></html>");

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}