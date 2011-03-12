package br.com.sigauti.auxiliar.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.sigauti.auxiliar.entity.Filial;
import br.com.sigauti.connection.Conexao;
import br.com.sigauti.connection.ConstantesJDBC;

public class FilialBD {

	private static Connection conn = null;
	
	public FilialBD() {

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
	public boolean incluir(Filial filial) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO FILIAL(DESCFILIAL) VALUES (?)";

			String nome = filial.getDescFilial();
			
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

	public List<Filial> listaFilial() {

		List<Filial> lista = new ArrayList<Filial>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM FILIAL");
				
				while(rs.next()){
				Filial filial = new Filial();
				filial.setIDFilial(rs.getInt(1));
				filial.setDescFilial(rs.getString(2));
				lista.add(filial);
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
}