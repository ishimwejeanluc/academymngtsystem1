package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		
		HttpSession session	 = req.getSession(false);
		RequestDispatcher dispatcher;
		try {
			if(session != null) {
				String sessionRole = (String) session.getAttribute("role");
				if(sessionRole.equalsIgnoreCase("hod")) {
					dispatcher = req.getRequestDispatcher("/HOD.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("registar")) {
					dispatcher = req.getRequestDispatcher("/registar.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("lecturer")) {
					dispatcher = req.getRequestDispatcher("/lecturer.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("student")) {
					dispatcher = req.getRequestDispatcher("/student.html");
					dispatcher.forward(req, res);
				}
				
			}
				else {
					dispatcher = req.getRequestDispatcher("/login.html");
					dispatcher.forward(req, res);
					}
			
			}catch(IOException | ServletException e) {
				e.printStackTrace();
			}
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session	 = req.getSession(false);
		RequestDispatcher dispatcher;
		try {
			if(session != null) {
				String sessionRole = (String) session.getAttribute("role");
				if(sessionRole.equalsIgnoreCase("hod")) {
					dispatcher = req.getRequestDispatcher("/HOD.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("registar")) {
					dispatcher = req.getRequestDispatcher("/registar.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("lecturer")) {
					dispatcher = req.getRequestDispatcher("/lecturer.html");
					dispatcher.forward(req, res);
				}
				if(sessionRole.equalsIgnoreCase("student")) {
					dispatcher = req.getRequestDispatcher("/student.html");
					dispatcher.forward(req, res);
				}
				
			}
				else {
					dispatcher = req.getRequestDispatcher("/login.html");
					dispatcher.forward(req, res);
					}
			
			}catch(IOException | ServletException e) {
				e.printStackTrace();
			}
		
	}
}
