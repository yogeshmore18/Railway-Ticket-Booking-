<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="dao.TrainDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
TrainDao dao=new TrainDao();
Train train=dao.fetch(Integer.parseInt(request.getParameter("number")));
%>

<fieldset>
<form action="edit" method="post">
<table>
<tr>
<td><label for="tnum">Train Number</label></td>
<td><input type="Number" id="tn" name="train_number" value="<%=train.getNumber() %>" readonly="readonly"></td>
</tr>
<tr>
<td><label for="tname">Train Name</label></td>
<td><input type="text" id="tname" name="train_name" value="<%=train.getName()%>"></td>
</tr>
<tr>
<td><label for="ts">Number of seat</label></td>
<td><input type="number" id="ts" name="number_of_seat" value="<%=train.getSeat()%>"></td>
</tr>
<tr>
<td><label for="station">Station</label></td>
<td><textarea rows="5" cols="30" name="station" id="station" ><%for(String train_station:train.getStations())
	{
	out.print(train_station+" , ");
	}
	%></textarea></td>
</tr>
<tr>
<td><label for="ts">Ticket Price</label></td>
<td><textarea rows="5" cols="30" name="Ticket_Price">
<%for(String ticket_price:train.getPrice())
	{
	out.print(ticket_price+" , ");
	} %>
</textarea></td>
</tr>
<tr>
<td><label for="time">Time</label></td>
<td><textarea rows="5" cols="30" id="time" name="time">
<%for(String train_time:train.getTime())
	{
	out.print(train_time+" , ");
	} %>
</textarea></td>
</tr>
<tr>
<td><label for="days">Days</label></td>
<td><textarea rows="5" cols="30" id="days" name="days">
<%for(String train_days:train.getDays())
	{
	out.print(train_days+" , ");
	} %>
</textarea></td>
</tr>
<tr><td><button type="submit">Edit</button></td> 
<td><button type="reset">Reset</button></td>
</tr>
</table>
</form>


</body>
</html>