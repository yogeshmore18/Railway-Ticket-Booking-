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
<% List<Train>list=(List<Train>)request.getAttribute("list"); %>
	
<table border="1">
<tr>
<th>Train Number</th>
<th>Train Name</th>
<th>From Station</th>
<th>To station</th>
<th>Stations</th>
<th>Time of Departure</th>
<th>Time of Arrival</th>
<th>Ticket Price</th>
<th>Available Days</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%for(Train train:list)
{%>


<tr>
<td><%=train.getNumber() %></td>
<td><%=train.getName()%></td>
<td><%=train.getStations()[0]%></td>
<td><%=train.getStations()[train.getStations().length-1]%></td>
<td><%=Arrays.toString(train.getStations())%></td>
<td><%=train.getTime()[0]%></td>
<td><%=train.getTime()[train.getTime().length-1]%></td>
<td><%=Arrays.toString(train.getPrice())%></td>
<td><%=Arrays.toString(train.getDays())%></td>
<td><a href="EditTrainInfo.jsp?number=<%=train.getNumber()%>"><button>Edit</button></a></td>
<td><a href="delete?number=<%=train.getNumber()%>"><button>Delete</button></a></td>
</tr>

	
<% }%>

</table>
<a href="ManagementHome.html">Back</a>
</body>
</html>