package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;

@WebServlet("/login")
public class LoginUser extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		int UserId=Integer.parseInt(req.getParameter("Id"));
		String Password=req.getParameter("Password");
		
		UserDao userdao=new UserDao();
		
		User user=userdao.find(UserId);
		
		if(user==null)
		{
			res.getWriter().print("<h1>Invalid ID</h1>");
		}
		else
		{
			if(user.getCreate_Password().equals(Password))
			{
				HttpSession session=req.getSession();
				session.setAttribute("user", user);
				
				res.getWriter().print("<h1>Login successfully</h1>");	
				req.getRequestDispatcher("UserHome.html").include(req, res);
			}
			else
			{
				res.getWriter().print("<h1>Invalid Password</h1>");	
				req.getRequestDispatcher("Login.html").include(req, res);
				
			}
		}
		
	}
}
