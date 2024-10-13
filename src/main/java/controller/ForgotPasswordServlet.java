package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ForgotPasswordServlet extends HttpServlet {

	
		 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        
		        String inputRole = request.getParameter("role");
		        String inputUsername = request.getParameter("username");

		       
		        Cookie[] cookies = request.getCookies();
		        String savedUsername = "";
		        String savedPassword = "";
		        boolean credentialsMatch = false;

		        if (cookies != null) {
		           
		            for (Cookie cookie : cookies) {
		                switch (inputRole.toUpperCase()) {
		                    case "STUDENT":
		                        if (cookie.getName().equals("student_username")) {
		                            savedUsername = cookie.getValue();
		                        }
		                        if (cookie.getName().equals("student_password")) {
		                            savedPassword = cookie.getValue();
		                        }
		                        break;
		                    case "LECTURER":
		                        if (cookie.getName().equals("lecturer_username")) {
		                            savedUsername = cookie.getValue();
		                        }
		                        if (cookie.getName().equals("lecturer_password")) {
		                            savedPassword = cookie.getValue();
		                        }
		                        break;
		                    case "REGISTRAR":
		                        if (cookie.getName().equals("registrar_username")) {
		                            savedUsername = cookie.getValue();
		                        }
		                        if (cookie.getName().equals("registrar_password")) {
		                            savedPassword = cookie.getValue();
		                        }
		                        break;
		                    case "HOD":
		                        if (cookie.getName().equals("hod_username")) {
		                            savedUsername = cookie.getValue();
		                        }
		                        if (cookie.getName().equals("hod_password")) {
		                            savedPassword = cookie.getValue();
		                        }
		                        break;
		                }
		            }

		            // Check if the provided username matches the saved one for the role
		            if (inputUsername.equals(savedUsername)) {
		                credentialsMatch = true;
		                // Send retrieved username and password to the JSP for display
		                request.setAttribute("username", savedUsername);
		                request.setAttribute("password", savedPassword);
		            }
		        }

		        if (!credentialsMatch) {
		            
		            request.setAttribute("errorMessage", "Invalid username or role.");
		        }

		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("forgotpassword.jsp");
		        dispatcher.forward(request, response);
		    
	}

}
