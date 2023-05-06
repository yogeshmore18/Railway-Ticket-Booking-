package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;
@WebServlet("/addtrain")
public class AddTrain extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		int train_number=Integer.parseInt(req.getParameter("train_number"));
		String train_name=req.getParameter("train_name");
		int seat=Integer.parseInt(req.getParameter("number_of_seat"));
		
		String station=req.getParameter("station");
		String[] train_station=station.split(",");
		
		String price=req.getParameter("Ticket_Price");
		String[] ticket_price=price.split(",");
		
		String time=req.getParameter("time");
		String[] train_time=time.split(",");
		
		String days=req.getParameter("days");
		String[] train_days=days.split(",");
		
		Train train=new Train();
		train.setNumber(train_number);
		train.setName(train_name);
		train.setSeat(seat);
		train.setStations(train_station);
		train.setPrice(ticket_price);
		train.setTime(train_time);
		train.setDays(train_days);
		
		TrainDao traindao=new TrainDao();
		traindao.save(train);
		
		res.getWriter().print("<h1 style='color:green'> Train Data Added Successfully </h1>");
		 req.getRequestDispatcher("ManagementHome.html").include(req, res);
	}
}
