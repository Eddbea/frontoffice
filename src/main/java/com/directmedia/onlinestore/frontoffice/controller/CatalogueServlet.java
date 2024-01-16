package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

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

        if (Catalogue.listOfWorks.isEmpty()) {
            Artist tomCruise = new Artist("Tom Cruise");
            Artist leonardoDiCaprio = new Artist("Leonardo Di Caprio");
            Artist louisDeFunes = new Artist("Louis de Funes");

            Work minorityReport = new Work("Minority Report");
            Work bad = new Work("Bad");
            Work leGendarmeDeSaintTropez = new Work("Le gendarme de Saint Tropez");

            minorityReport.setRelease(2002);
            bad.setRelease(1987);
            leGendarmeDeSaintTropez.setRelease(1964);
            minorityReport.setSummary("Minority Report place le spectateur dans un futur proche cyberpunk, une dystopie dont le cadre est à Washington de 2054 où des êtres humains mutants, les précogs, peuvent prédire les crimes à venir grâce à leur don de prescience");
            bad.setSummary("Bad est le septième album de Michael Jackson et son 3e album solo chez Epic/Sony et le 3e et dernier album co-produit par Quincy Jones. C'est l'un des albums les plus vendus de l'histoire et celui qui contient le plus de morceaux classés no 1 dans les palmarès.");
            leGendarmeDeSaintTropez.setSummary("le film raconte les aventures de Ludovic Cruchot, un gendarme très « service-service », muté dans la cité balnéaire de Saint-Tropez, sur la côte d'Azur, avec le grade de maréchal-des-logis-chef.");
            minorityReport.setGenre("Science Fiction");
            bad.setGenre("Pop");
            leGendarmeDeSaintTropez.setGenre("Comédie");

            Catalogue.listOfWorks.add(minorityReport);
            Catalogue.listOfWorks.add(bad);
            Catalogue.listOfWorks.add(leGendarmeDeSaintTropez);
        }

        out.println("<html><body><h1>Oeuvres au catalogue</h1><BR/><BR/>");
        for (Work item : Catalogue.listOfWorks) {
            out.println(item.getTitle() + " (" + item.getRelease() + ")<BR/>");
        }

        out.println("</body");
        out.println("</html>");
    }
}

