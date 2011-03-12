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
	AcessoBD bd = new AcessoBD();
	List<Acesso> lista = bd.listaAcesso();
	out.println("<table border=5 />");	
	out.println("<th>ID</th>");
	out.println("<th>Nome</th>");
	out.println("<th>Editar</th>");
	out.println("<th>Excluir</th>");
	out.println("</tr>");
	
	for (Acesso a : lista){
		out.println("<tr>");
		out.println("<td>" +a.getIDAcesso()+"</td>");
		out.println("<td>" +a.getDescAcesso()+"</td>");
		out.println("<td>" +"<a href=\"editentity.jsp?entity=acesso&id="+ a.getIDAcesso().toString()+"\"><img src=\"img\\edit.png\"/></a>"+"</td>");
		out.println("<td>" +"<a href=\"deleteentity.jsp?entity=acesso&id="+ a.getIDAcesso().toString()+"\"><img src=\"img\\delete.png\"/></a>"+"</td>");
		out.println("</tr>");
	}
%>

</head>
<body>

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Acesso</font></u></h1>
<form action="AcessoAction" method="get">
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