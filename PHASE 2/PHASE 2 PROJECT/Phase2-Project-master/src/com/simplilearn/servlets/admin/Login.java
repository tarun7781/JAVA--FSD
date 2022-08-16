package com.simplilearn.servlets.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/login")
public class Login extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean isLoggedIn = false;
    public static String password = "Airline";
    public static String email = "airline@flyaway.com";

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("username");
        String pass = req.getParameter("password");

        if (email.equals(Login.email) && pass.equals(Login.password)){
            isLoggedIn = true;
            out.println("You have LoggedIn");
//            resp.sendRedirect("/dashboard.html");
//            out.print("<a href=\"dashboard.html\">Home</a>");
            try {
				req.getRequestDispatcher("dashboard.html").forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        else {
            isLoggedIn = false;
            out.println("Login Failed : Incorrect email or Password");
       
        }
        out.close();
   
        
        
    }
}