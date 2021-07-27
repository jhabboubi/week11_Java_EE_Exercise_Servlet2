package org.perscholas;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class MyServletDemo extends HttpServlet {

    private String mymsg;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.mymsg = "Hello World!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + mymsg + "</h1>");
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("myname");
//        String password = req.getParameter("password");
//        PrintWriter printWriter = resp.getWriter();
//        resp.setContentType("text/html");
//
//        printWriter.print("<html><head>");
//        printWriter.print("<title> Welcome to the Web World </title>");
//        printWriter.println("<h2> Username is: " + username + "</h2> \n");
//        printWriter.println("<h2> Password is: " + password + "</h2> \n");
//        printWriter.println("</head></html");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = "ramon";
        String p = "123";
        String username = req.getParameter("myname");
        String password = req.getParameter("password");

        if (u.equals(username) && p.equals(password)) {
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/success.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/fail.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
