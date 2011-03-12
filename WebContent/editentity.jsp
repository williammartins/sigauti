<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="br.com.sigauti.auxiliar.dao.*" %>
<%@page import="br.com.sigauti.auxiliar.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%
	String entity = request.getParameter("entity");
	if (entity.equals("acesso")){
		response.sendRedirect("acesso_edit.jsp?id="+ request.getParameter("id"));
	}
%>
</head>
<body>

</body>
</html>