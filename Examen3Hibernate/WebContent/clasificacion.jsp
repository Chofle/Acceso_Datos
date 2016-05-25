<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="dominio.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CLASIFICACIÓN</title>
</head>
<body>

<center>

<h2> CLASIFICACIÓN DE LA LIGA</h2>

<table border="1">



<tr>
	<th>Nombre</th>
	<th>Puntos</th>
</tr>
<%
ArrayList<Equipo> listaEquipos=(ArrayList<Equipo>) request.getAttribute("equipos");
if (listaEquipos!=null)
	for(int i=0;i<listaEquipos.size();i++){
		Equipo e=(Equipo) listaEquipos.get(i); %>
		<tr> <td> <%=e.getNombre() %> </td>
			 <td> <%=3%> </td>
		</tr>
<%	} %>

</table>
<br/>
<br/>
<a href="index.jsp">Inicio</a>

</center>


</body>
</html>