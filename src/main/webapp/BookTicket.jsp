<%@page import="dao.TrainDao"%>
<%@page import="dto.Train"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book ticket</title>
</head>
<body>
<% User user=(User)session.getAttribute("user"); %>
<%
if(user==null)
{
	response.getWriter().print("<h1 style='color:red'>Session Expired login again<h1>");
	request.getRequestDispatcher("Login.html").include(request, response);
	
}
else
{ 
	int train_number=Integer.parseInt(request.getParameter("train_number"));
	TrainDao dao=new TrainDao();
	Train train=dao.fetch(train_number);
	if(train==null)
	{
		response.getWriter().print("<h1 style='color:red'>Invalid Train Number<h1>");
		request.getRequestDispatcher("UserHome.html").include(request, response);
	}
	else
	{%>
		<h2>Hello <%=user.getFirst_Name()+ " "+user.getLast_Name() %></h2><br>
		<form action="bookticket" method="post">
		<label>User Id:</label>
		<input type="text" name="uid" value="<%=user.getId()%>"  readonly="readonly"><br>
		
		<label>Train Number:</label>
		<input type="number" name="tn" value="<%=train_number%>"  readonly="readonly"><br>
		
		<label>From:</label>
			<select name="from">
		<% for(int i=0;i<train.getStations().length-1;i++) 
		{%>
		<option><%=train.getStations()[i]%></option>
		<%} %>
	</select><br>
		
		<label>To:</label>
		<select name="to">
		<% for(int i=1;i<train.getStations().length;i++) 
		{%>
		<option><%=train.getStations()[i]%></option>
		<%} %>
		</select><br>
	
		<label>Date :</label>
		<input type="date" name="date" value="" ><br>
	
		<label>No of Seats:</label>
		<input type="number" name="seat" value=""><br>
		
		
		<button>Book</button><button type="reset">Rest</button>
		</form>
		<a href="UserHome.html"><button>Back</button></a>
<%}
	
} %>

</body>
</html>