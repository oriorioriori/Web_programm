package ru.mirea.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
/**
 * Created by Arina on 27.05.2017.
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");
        String role = request.getParameter("Role");
        String wr = "Login: " + login + " " + "Password: " + password + " " + new Date();
        Writer out = response.getWriter();
        out.write("<html><h1>" + wr + "</h1>" +
                "<a href = \"http://localhost:8080/MainServlet/SignIn\">Sign in</a></html>");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\мвидео\\Desktop\\lab\\log.txt",true), "UTF-8"));
        }
        catch (Exception e){

        }
        printWriter.println(login);
        printWriter.println(password);
        printWriter.println(role);
        printWriter.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Hello!");
        getServletConfig().getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
        request.getSession().setAttribute("Login", true);
    }
}
