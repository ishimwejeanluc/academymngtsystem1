package controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class AuthenticationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");  
        
        
        Cookie[] cookies = req.getCookies();
        
       
        
        if (cookies != null) {
        	

            
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                
                
                if (cookieName.equals("student_username") && cookie.getValue().equals(username)) {
                    Cookie passwordCookie = getCookieByName(cookies, "student_password");
                    if (passwordCookie != null && passwordCookie.getValue().equals(password)) {
                    	HttpSession session = req.getSession();
                        session.setAttribute("role", "student");
                        session.setMaxInactiveInterval(60);
                        handleCookies(res, username, password, rememberMe);  // Set persistent or non-persistent cookies
                        RequestDispatcher dispatcher = req.getRequestDispatcher("home");
                        dispatcher.forward(req, res);
                    }
                    else {
                        
  	               	  PrintWriter out = res.getWriter(); 
  	                  out.println("<h1> Invalid crendentials </h1");
  	                   RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
  	             	   dispatcher.include(req, res);
                 }
                } else if (cookieName.equals("lecturer_username") && cookie.getValue().equals(username)) {
                    Cookie passwordCookie = getCookieByName(cookies, "lecturer_password");
                    if (passwordCookie != null && passwordCookie.getValue().equals(password)) {
                    	HttpSession session = req.getSession();
                        session.setAttribute("role", "lecturer");
                        session.setMaxInactiveInterval(60);
                        handleCookies(res, username, password, rememberMe);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("home");
                        dispatcher.forward(req, res);
                    }else {
                        
  	               	  PrintWriter out = res.getWriter(); 
  	                  out.println("<h1> Invalid crendentials </h1");
  	                   RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
  	             	   dispatcher.include(req, res);
                 }
                } else if (cookieName.equals("registrar_username") && cookie.getValue().equals(username)) {
                    Cookie passwordCookie = getCookieByName(cookies, "registrar_password");
                    if (passwordCookie != null && passwordCookie.getValue().equals(password)) {
                    	HttpSession session = req.getSession();
                        session.setAttribute("role", "registrar");
                        session.setMaxInactiveInterval(60);
                        handleCookies(res, username, password, rememberMe);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("home");
                        dispatcher.forward(req, res);
                    }else {
                        
  	               	  PrintWriter out = res.getWriter(); 
  	                  out.println("<h1> Invalid crendentials </h1");
  	                   RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
  	             	   dispatcher.include(req, res);
                 }
                } else if (cookieName.equals("hod_username") && cookie.getValue().equals(username)) {
                    Cookie passwordCookie = getCookieByName(cookies, "hod_password");
                    if (passwordCookie != null && passwordCookie.getValue().equals(password)) {
                    	HttpSession session = req.getSession();
                        session.setAttribute("role", "hod");
                        session.setMaxInactiveInterval(60);
                        handleCookies(res, username, password, rememberMe);
                        RequestDispatcher dispatcher = req.getRequestDispatcher("home");
                        dispatcher.forward(req, res);
                    }else {
                        
  	               	  PrintWriter out = res.getWriter(); 
  	                  out.println("<h1> Invalid crendentials </h1");
  	                   RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
  	             	   dispatcher.include(req, res);
                 }
                }
                
            }
            
        }
    }

    
    private Cookie getCookieByName(Cookie[] cookies, String name) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }

    
    private void handleCookies(HttpServletResponse res, String username, String password, String rememberMe) {
       
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        
        if (rememberMe == null) {
            
            usernameCookie.setMaxAge(-1); 
            passwordCookie.setMaxAge(-1); 
        } else {
            // Persistent cookies (remain for multiple sessions)
            usernameCookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
            passwordCookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
        }

        
        res.addCookie(usernameCookie);
        res.addCookie(passwordCookie);
    }
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		dispatcher = req.getRequestDispatcher("/login.html");
		dispatcher.include(req, res);
		
	}
}
