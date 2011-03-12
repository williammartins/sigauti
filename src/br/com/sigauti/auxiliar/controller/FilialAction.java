package br.com.sigauti.auxiliar.controller;
import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.sigauti.auxiliar.dao.FilialBD;
import br.com.sigauti.auxiliar.entity.Filial;


public class FilialAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilialAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FilialBD bd = new FilialBD();
		Filial filial = new Filial();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String op = request.getParameter("op");

		out.println("<html>");
		out.println("<head>");
		out.println("<body bgcolor=Yellow>");
		out.println("<title>Sigauti</title>");
		out.println("</head>");
		out.println("<body><center><b>");
		
		// Metodo que verifica a inclusao
		if (op.equals("incluir")){
			
			String nome = request.getParameter("nome");
			filial.setDescFilial(nome);
		
			boolean inc = true;
				inc = bd.incluir(filial);
				if (inc){
					out.println("Cadastrado com Sucesso<br /><br />");
					out.println("<a href='filial.jsp'>Voltar </a>");
				}else{
					out.println("Nao foi possivel incluir!!!<br /><br />");
					out.println("<a href='filial.jsp'>Voltar </a>");
				}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
