package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;
@WebServlet("/addmoney")
public class AddMoney extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("user");
		if(user==null)
		{
			res.getWriter().print("<h1 style='color:green'> Session Expired login again</h1>");
			 req.getRequestDispatcher("UserHome.html").include(req, res);
			
		}
		else{
		user.setWallet(user.getWallet()+Double.parseDouble(req.getParameter("amount")));
		UserDao dao=new UserDao();
		dao.update(user);
		
		res.getWriter().print("<h1 style='color:green'> Money Added successfully in wallet</h1>");
		 req.getRequestDispatcher("AddMoney.jsp").include(req, res);
		}
	}

}
