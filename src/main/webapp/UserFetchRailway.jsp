<%@page import="java.util.Arrays"%>
<%@page import="dto.Train"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Available Trains</h2>

<% List<Train>list=(List<Train>)request.getAttribute("list"); %>
	
<table border="1">
<tr>
<th>Train Number</th>
<th>Train Name</th>
<th>Seats Available</th>
<th>From Station</th>
<th>To station</th>

<th>Time of Departure</th>
<th>Time of Arrival</th>

<th>Available Days</th>
<th>Book</th>

</tr>

<%for(Train train:list)
{%>


<tr>
<td><%=train.getNumber() %></td>
<td><%=train.getName()%></td>
<td><%=train.getSeat()%></td>
<td><%=train.getStations()[0]%></td>
<td><%=train.getStations()[train.getStations().length-1]%></td>

<td><%=train.getTime()[0]%></td>
<td><%=train.getTime()[train.getTime().length-1]%></td>
<td><%=Arrays.toString(train.getDays())%></td>
<td><a <%-- href="EditTrainInfo.jsp?number=<%=train.getNumber()%>" --%>><button>Book</button></a></td>

</tr>

	
<% }%>

</table>
<a href="UserHome.html">Back</a>




</body>
</html>