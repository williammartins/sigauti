<%@page import="br.com.sigauti.auxiliar.controller.AcessoAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.sigauti.auxiliar.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%
	String entity = request.getParameter("entity");
	if (entity.equals("acesso")){
		AcessoBD ab = new AcessoBD();
		ab.deteteAcesso(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("acesso.jsp");
	}
%>
</head>
<body>
</body>
</html>