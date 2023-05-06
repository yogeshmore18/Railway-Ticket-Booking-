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
@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		int Number=Integer.parseInt(req.getParameter("number"));
		
		TrainDao dao=new TrainDao();
		dao.delete(Number);
		
		List<Train> list=dao.fetchAll();
		
		if(list.isEmpty())
		{
			res.getWriter().print("<h1>NO Railway Information Available</h1>");
			req.getRequestDispatcher("ManagementHome.html").include(req, res);
		}
		
		res.getWriter().print("<h1>Deleted successfully... </h1>");
		req.setAttribute("list", list);
		req.getRequestDispatcher("FetchRailwayInfo.jsp").include(req, res);
	}
}
