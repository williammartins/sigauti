package br.com.sigauti.auxiliar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.sigauti.auxiliar.entity.Acesso;
import br.com.sigauti.connection.Conexao;
import br.com.sigauti.connection.ConstantesJDBC;

public class AcessoBD {

	private static Connection conn = null;
	
	public AcessoBD() {

		try {
			conn = Conexao.conectar(ConstantesJDBC.MYSQL_DRIVER,
					ConstantesJDBC.MYSQL_URL, ConstantesJDBC.MYSQL_USER,
					ConstantesJDBC.MYSQL_PASS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fecharConexao(){
		Conexao.desconectar(conn);
	}
	
	// Método que Inclui
	public boolean incluir(Acesso acesso) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO ACESSO (DESCACESSO) VALUES (?)";

			String nome = acesso.getDescAcesso();
			
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setString(1, nome);
				ps.executeUpdate();
				resultado = true;
				
			}catch(SQLException ex){
				resultado = false;
				System.out.println("erro no seu codigo");
				System.err.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}finally{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return resultado;
	}
	
	public Boolean deteteAcesso(Integer id){
		String sql = "Delete From Acesso Where IDAcesso=" + id.toString();
		try {
			PreparedStatement ps = null;
			if (conn == null){
				return false;
			}
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public List<Acesso> listaAcesso() {

		List<Acesso> lista = new ArrayList<Acesso>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM ACESSO");
				
				while(rs.next()){
				Acesso acesso = new Acesso();
				acesso.setIDAcesso(rs.getInt(1));
				acesso.setDescAcesso(rs.getString(2));
				lista.add(acesso);
			}
			rs.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}
	
	public boolean editAcesso(Acesso acesso) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "UPDATE ACESSO SET DESCACESSO = ? WHERE IDAcesso = ?";

			String nome = acesso.getDescAcesso();
			int id = acesso.getIDAcesso();
			try
			{
				ps = conn.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setInt(2, id);
				ps.executeUpdate();
				resultado = true;
			}catch(SQLException ex){
				resultado = false;
				System.out.println("erro no seu codigo");
				System.err.println("SQLException: " + ex.getMessage());
				ex.printStackTrace();
			}finally{
				try {
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return resultado;
	}
	
	public Acesso findAcesso(Integer id) {
		
		Acesso a = new Acesso();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT IDACESSO, DESCACESSO FROM ACESSO WHERE IDACESSO=" + id.toString());
				
				a.setIDAcesso(rs.getInt(1));
				a.setDescAcesso(rs.getString(2));
			
				rs.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}
}