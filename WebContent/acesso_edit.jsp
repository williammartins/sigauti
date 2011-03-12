<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="br.com.sigauti.auxiliar.dao.*" %>
<%@page import="br.com.sigauti.auxiliar.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="style/style.css">
<title>Sigauti</title>
<%
	AcessoBD ab = new AcessoBD();
	Acesso a = new Acesso();
	a = ab.findAcesso( Integer.parseInt(request.getParameter("id")));
%>
</head>
<body>

<h1>Alteração de Acesso</h1>
<form action="AcessoAction" method="get">
<table border="0">
<tr>
	<input type="text" name="id" readonly="readonly"/>
<br><td><b>Nome:</b></td>
	<td><input type="text" name="nome" maxlength="50" size="35" value="<% a.getDescAcesso(); %>"/></td>
</tr>
<td> </td>
<th><input type="submit" name="enviar" value="Alterar" />
<br><br><a href="index.jsp">Voltar</a></b>
</th>
</table>
<input type="hidden" name="op" value="alterar" />
</form>
<b>
<p/><br />

</body>
</html>