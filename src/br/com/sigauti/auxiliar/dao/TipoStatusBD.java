package br.com.sigauti.auxiliar.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import br.com.sigauti.auxiliar.entity.TipoStatus;
import br.com.sigauti.connection.Conexao;
import br.com.sigauti.connection.ConstantesJDBC;

public class TipoStatusBD {

	private Connection conn = null;
	
	public TipoStatusBD() {

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
	public boolean incluir(TipoStatus tipostatus) {

		boolean resultado = true;

		PreparedStatement ps = null;

		if (conn == null){
			return false;
		}
		
		String sql = "INSERT INTO TIPOSTATUS (DESCTIPOSTATUS	) VALUES (?)";

			String nome = tipostatus.getDescTipoStatus();
			
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

	public List<TipoStatus> listaStatus() {

		List<TipoStatus> lista = new ArrayList<TipoStatus>();
		Statement query = null;
		ResultSet rs = null;

		if(conn != null){
			try {
				query = conn.createStatement();

				rs = query.executeQuery("SELECT * FROM TIPOSTATUS");
				
				while(rs.next()){
				TipoStatus tipostatus = new TipoStatus();
				tipostatus.setIDTipoStatus(rs.getInt(1));
				tipostatus.setDescTipoStatus(rs.getString(2));
				lista.add(tipostatus);
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