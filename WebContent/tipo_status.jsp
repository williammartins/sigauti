<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="br.com.sigauti.auxiliar.dao.*" %>
<%@page import="br.com.sigauti.auxiliar.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sigauti</title>

	<% 
	TipoStatusBD bd = new TipoStatusBD();
	List<TipoStatus> lista = bd.listaStatus();
	out.println("<table border=5 />");	
	out.println("<th>ID_STATUS</th>");
	out.println("<th>NOME</th>");
	out.println("<th>Ação</th>");
	out.println("<th>Ação</th>");
	out.println("</tr>");
	
	for (TipoStatus a : lista){
		out.println("<tr>");
		out.println("<td>" +a.getIDTipoStatus()+"</td>");
		out.println("<td>" +a.getDescTipoStatus()+"</td>");
		out.println("</tr>");
	}
%>

</head>
<body bgcolor="Yellow">

<h1><u><font face= "Monotype Corsiva" color="Blue" />Cadastro de Status</font></u></h1>
<form action="TipoStatusAction" method="get">
<table border="0">
<tr>
<br><td><b>Nome:</b></td>
	<td><input type="text" name="nome" maxlength="50" size="35" /></td>
</tr>

<td> </td>
<th><input type="submit" name="enviar" value="Cadastrar" />
<input type="reset" name="limpar" value="Limpar" />
<br><br><a href="###">Voltar</a></b>
</th>
</table>
<input type="hidden" name="op" value="incluir" />
</form>
<b>
<p/><br />

</body>
</html>