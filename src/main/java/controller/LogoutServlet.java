package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
        doPost(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        Cookie persistentCookie = new Cookie("username", "");
        persistentCookie.setMaxAge(0); 
        persistentCookie.setPath("/academymanagementsystem"); 
        res.addCookie(persistentCookie);
        
        
        if (req.getSession(false) != null) {
            req.getSession().invalidate();
        }

       
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
        dispatcher.forward(req, res);
    }
}
