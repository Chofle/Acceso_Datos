<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="dominio.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUINIELA</title>
</head>
<body>

<center>

<h2> QUINIELA JORNADA </h2>

<table border="1">



<tr>
	<th>Partido</th>
	<th>Resultado</th>
</tr>
<%
ArrayList<Partido> listaPartidos=(ArrayList<Partido>) request.getAttribute("partido");
if (listaPartidos!=null)
	for(int i=0;i<listaPartidos.size();i++){
		Partido p=(Partido) listaPartidos.get(i); %>
		<tr> <td> <%=p.getEquipo_local() +  "--" + p.getEquipo_visitante() %> </td>
			 <td> <%="" %> </td>
		</tr>
<%	} %>

</table>
<br/>
<br/>
<a href="index.jsp">Inicio</a>

</center>


</body>
</html>