<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>resultado de Multiplicar</title>
</head>
<body>
<h1>Resultado de la Tabla de Multiplicar</h1>
<%int jnum = Integer.parseInt(request.getParameter("numero")); %>
<br>
<h2>Tabla del <%=jnum %></h2>
<table>
<%for(int i=1;i<=10;i++) {%>
	<tr>
		<td><%=jnum %> x <%=i %> =</td> <td><%=jnum*i %></td>
	</tr>
<%} %>
</table>
<br>
<a href="tablasmultiplicar.jsp">Regresar a volver a pedir el numero</a>
</body>
</html>