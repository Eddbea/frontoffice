package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "AddToCartServlet", value = "/addToCart")
public class AddToCartServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

        String idAsString = request.getParameter("identifiant");

        try {
            long idAsLong = Long.parseLong(idAsString);

            ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");

            if (cart == null) {
                cart = new ShoppingCart();
                request.getSession().setAttribute("cart", cart);
            }

        /*for(Work work : Catalogue.listOfWorks){
            if(work.getId()==idAsLong){
                cart.getItems().add(work);
            }
        }*/

            Optional<Work> optionalWork = Catalogue.listOfWorks.stream().filter(work -> work.getId() == idAsLong).findAny();
            if (optionalWork.isPresent()) {
                cart.getItems().add(optionalWork.get());
            }

            PrintWriter out = resp.getWriter();
            out.print("<html><body>Oeuvre ajoutee au caddie (" + cart.getItems().size() + ")</br><a href=\"catalogue\"> Retour au catalogue</a></body></html>");

        } catch (NumberFormatException n) {
            n.printStackTrace();
        }
    }
}