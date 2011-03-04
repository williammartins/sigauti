package br.com.sigauti.auxiliar.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.sigauti.auxiliar.dao.TipoStatusBD;
import br.com.sigauti.auxiliar.entity.TipoStatus;


public class TipoStatusAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipoStatusAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TipoStatusBD bd = new TipoStatusBD();
		TipoStatus tipostatus = new TipoStatus();

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
			tipostatus.setDescTipoStatus(nome);
		
			boolean inc = true;
				inc = bd.incluir(tipostatus);
				if (inc){
					out.println("Status Cadastrado com Sucesso<br /><br />");
					out.println("<a href='tipo_status.jsp'>Voltar</a><br /><br />");
				//	out.println("<a href='area_adm.jsp'>Voltar </a>");
				}else{
					out.println("Nao foi possivel incluir!!!<br /><br />");
					out.println("<a href='Voltar.jsp'>Cadastrar Outro Status</a><br /><br />");
				//	out.println("<a href='area_adm.jsp'>Voltar </a>");
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
