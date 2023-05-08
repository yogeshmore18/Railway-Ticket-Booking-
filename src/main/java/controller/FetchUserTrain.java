package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;
import dto.User;

@WebServlet("/usertraininfo")
public class FetchUserTrain extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
	
		User user=(User) req.getSession().getAttribute("user");
		if(user==null)
		{
			res.getWriter().print("<h1 style='color:green'> Session Expired login again</h1>");
			 req.getRequestDispatcher("UserHome.html").include(req, res);
			
		}
		else{
		TrainDao dao=new TrainDao();
		List<Train> list=dao.fetchAll();
		
		if(list.isEmpty())
		{
			res.getWriter().print("<h1 style='color:green'> NO railways Informatiom </h1>");
			 req.getRequestDispatcher("UserHome.html").include(req, res);
		}
		else
		{
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("UserFetchRailway.jsp").forward(req, res);
		}
		}
	}
}
