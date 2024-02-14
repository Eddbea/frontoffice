package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WorkDetailsServlet", value = "/work-details")
public class WorkDetailsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");

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

             request.setAttribute("work", work);
            RequestDispatcher disp=request.getRequestDispatcher("/work-details.jsp");
            disp.forward(request,response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}