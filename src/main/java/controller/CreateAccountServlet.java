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
@WebServlet(value = "/createAccount")
public class CreateAccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        String confirmPassword = req.getParameter("confirmPassword");
     if( password.equals(confirmPassword)) {
        
        if (role.equalsIgnoreCase("STUDENT")) {
            
            Cookie studentUsernameCookie = new Cookie("student_username", username);
            Cookie studentPasswordCookie = new Cookie("student_password", password);
            Cookie studentRoleCookie = new Cookie("student_role", role);

          
            studentUsernameCookie.setMaxAge(60 * 60 * 24 * 7);
            studentPasswordCookie.setMaxAge(60 * 60 * 24 * 7);
            studentRoleCookie.setMaxAge(60 * 60 * 24 * 7);


            res.addCookie(studentUsernameCookie);
            res.addCookie(studentPasswordCookie);
            res.addCookie(studentRoleCookie);

        } else if (role.equalsIgnoreCase("LECTURER")) {
            
            Cookie lecturerUsernameCookie = new Cookie("lecturer_username", username);
            Cookie lecturerPasswordCookie = new Cookie("lecturer_password", password);
            Cookie lecturerRoleCookie = new Cookie("lecturer_role", role);

            // Set max age for persistent cookies (1 week)
            lecturerUsernameCookie.setMaxAge(60 * 60 * 24 * 7);
            lecturerPasswordCookie.setMaxAge(30 * 24 * 60 * 60);
            lecturerRoleCookie.setMaxAge(30 * 24 * 60 * 60);

            // Add cookies to response
            res.addCookie(lecturerUsernameCookie);
            res.addCookie(lecturerPasswordCookie);
            res.addCookie(lecturerRoleCookie);

        } else if (role.equalsIgnoreCase("REGISTRAR")) {
            // Create cookies for registrar
            Cookie registrarUsernameCookie = new Cookie("registrar_username", username);
            Cookie registrarPasswordCookie = new Cookie("registrar_password", password);
            Cookie registrarRoleCookie = new Cookie("registrar_role", role);

            // Set max age for persistent cookies (1 week)
            registrarUsernameCookie.setMaxAge(60 * 60 * 24 * 7);
            registrarPasswordCookie.setMaxAge(60 * 60 * 24 * 7);
            registrarRoleCookie.setMaxAge(60 * 60 * 24 * 7);

            // Add cookies to response
            res.addCookie(registrarUsernameCookie);
            res.addCookie(registrarPasswordCookie);
            res.addCookie(registrarRoleCookie);

        } else if (role.equalsIgnoreCase("HOD")) {
            // Create cookies for HOD
            Cookie hodUsernameCookie = new Cookie("hod_username", username);
            Cookie hodPasswordCookie = new Cookie("hod_password", password);
            Cookie hodRoleCookie = new Cookie("hod_role", role);

            // Set max age for persistent cookies (1 week)
            hodUsernameCookie.setMaxAge(60 * 60 * 24 * 7);
            hodPasswordCookie.setMaxAge(60 * 60 * 24 * 7);
            hodRoleCookie.setMaxAge(60 * 60 * 24 * 7);

            // Add cookies to response
            res.addCookie(hodUsernameCookie);
            res.addCookie(hodPasswordCookie);
            res.addCookie(hodRoleCookie);
        }
        PrintWriter out = res.getWriter(); 
        out.println("<h1> Account has been successful created </h1");
       RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.html");
 	   dispatcher.include(req, res);
    }
    
   else {
	   PrintWriter out = res.getWriter();
	   out.println("<h1> Password does not match </h1");
	   RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.html");
 	   dispatcher.include(req, res);
    }
   }
    }

