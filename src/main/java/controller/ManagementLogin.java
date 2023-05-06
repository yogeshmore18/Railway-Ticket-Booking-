package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManagementLogin")
public class ManagementLogin extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String Email=req.getParameter("mail_id");
		String Password=req.getParameter("password");

		
	if(Email.equals("admin@gmail.com"))
	{
		if(Password.equals("admin"))
		{
			res.getWriter().print("<h1>Successfull login</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, res);
		}
		else
		{
			res.getWriter().print("<h1>invalid password</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, res);
		}
	}
	else
	{
		res.getWriter().print("<h1>Invalid Emnail Id</h1>");
		req.getRequestDispatcher("ManagementLogin.html").include(req, res);
	}
	}
	
}
