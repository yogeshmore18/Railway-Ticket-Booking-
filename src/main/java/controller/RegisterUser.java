package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/register")
public class RegisterUser extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String First_Name=req.getParameter("First_Name");
   	 String Last_Name=req.getParameter("Last_Name");
   	 long Mobile_Number=Long.parseLong(req.getParameter("Mobile_Number"));
   	 String Email_ID=req.getParameter("Email_ID");
   	 String Gender=req.getParameter("Gender");
   	 Date Date_Of_Birth=Date.valueOf(req.getParameter("Date_Of_Birth"));
   	 String Address=req.getParameter("Address");
   	 String Create_Password=req.getParameter("Create_Password");
   	 String Confirm_Password=req.getParameter("Confirm_Password");
   	 int Age=Period.between(Date_Of_Birth.toLocalDate(), LocalDate.now()).getYears();
   	 
   	 
   	if(Create_Password.equals(Confirm_Password))
	 {
		 if(Age>18)
		 {
			 User user=new User();
			 user.setFirst_Name(First_Name);
			 user.setLast_Name(Last_Name);
			 user.setMobile_Number(Mobile_Number);
			 user.setEmail_ID(Email_ID);
			 user.setGender(Gender);
			 user.setDate_Of_Birth(Date_Of_Birth);
			 user.setAddress(Address);
			 user.setCreate_Password(Create_Password);
			 user.setConfirm_Password(Confirm_Password);
			 user.setAge(Age);
			 UserDao userDao=new UserDao();
			 userDao.save(user);
			 
			 res.getWriter().print("<h1 style='color:green'> Account Created Successfully</h1>");
			 res.getWriter().print("<h1 style='color:green'> Your ID is:"+user.getId()+"</h1>");
			 req.getRequestDispatcher("Home.html").include(req, res);
		 }
		 else{
			 res.getWriter().print("<h1 style='color:red'>Your Age Is Below 18 You Cannot Create Account</h1>");
   		 req.getRequestDispatcher("Register.html").include(req, res);
		 }
	 }
	 else
	 {
		 res.getWriter().print("<h1 style='color:red'>Password Miss-Match</h1>");
		 req.getRequestDispatcher("Register.html").include(req, res);
	 }
}
   	 
}
