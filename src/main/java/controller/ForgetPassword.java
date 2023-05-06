package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
@WebServlet("/ForgotPassword")
public class ForgetPassword extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		int Id=Integer.parseInt(req.getParameter("id"));
		UserDao dao=new UserDao();
		User user=dao.find(Id);
		
		if(user==null)
		{
			res.getWriter().print("<h1>Invalid ID</h1>");	
			req.getRequestDispatcher("ForgetPassword.html").include(req, res);
		}
		else
		{
			Long mobile_number=Long.parseLong(req.getParameter("Mobile_Number"));
			Date dob=Date.valueOf(req.getParameter("Date_Of_Birth"));
			if(mobile_number.equals(user.getMobile_Number()) && dob.equals(user.getDate_Of_Birth()))
			{
				user.setConfirm_Password(req.getParameter("New_password"));
				user.setCreate_Password(req.getParameter("New_password"));	

				 dao.update(user);
				 res.getWriter().print("<h1> Password updated</h1>");
			}
			else
			{
				res.getWriter().print("<h1>Invalid Details</h1>");
				req.getRequestDispatcher("ForgetPassword.html").include(req, res);
			}
		}
	}

	
}
