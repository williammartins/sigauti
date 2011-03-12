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
	FilialBD bd = new FilialBD();
	List<Filial> lista = bd.listaFilial();
	out.println("<table border=5 />");	
	out.println("<th>ID_FILIAL</th>");
	out.println("<th>NOME</th>");
	out.println("<th>Ação</th>");
	out.println("<th>Ação</th>");
	out.println("</tr>");
	
	for (Filial a : lista){
		out.println("<tr>");
		out.println("<td>" +a.getIDFilial()+"</td>");
		out.println("<td>" +a.getDescFilial()+"</td>");
		out.println("</tr>");
	}
%>

</head>
<body bgcolor="Yellow">

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Acesso</font></u></h1>
<form action="FilialAction" method="get">
<table border="0">
<tr>
<br><td><b>Nome:</b></td>
	<td><input type="text" name="nome" maxlength="50" size="35" /></td>
</tr>

<td> </td>
<th><input type="submit" name="enviar" value="Cadastrar" />
<input type="reset" name="limpar" value="Limpar" />
<br><br><a href="index.jsp">Voltar</a></b>
</th>
</table>
<input type="hidden" name="op" value="incluir" />
</form>
<b>
<p/><br />

</body>
</html>