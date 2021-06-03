package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws SQLException,
			ClassNotFoundException{
		
		String sql = "INSERT INTO fabricante (nome) VALUES (?)";
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setString(1, f.getNome());
		
		pstmt.executeUpdate();
		
	}
	
	public void excluir(Fabricante f) throws SQLException,
		ClassNotFoundException{
		
		String sql = "DELETE FROM fabricante WHERE idFabricante = ?";
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setLong(1, f.getIdFabricante());
		
		pstmt.executeUpdate();
		
	}
	
	public void alterar(Fabricante f)throws SQLException,
		ClassNotFoundException{
		
		String sql = "UPDATE fabricante SET nome = ? WHERE idFabricante = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		pstmt.setString(1, f.getNome());
		pstmt.setLong(2, f.getIdFabricante());
		
		pstmt.executeUpdate();
		
	}
	
	public Fabricante getFabricantePorId(Fabricante f) throws SQLException,
		ClassNotFoundException{
		
		String sql = "SELECT idFabricante, nome " +
					 "FROM fabricante WHERE idFabricante = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setLong(1, f.getIdFabricante());
		
		ResultSet rs = pstmt.executeQuery();
		
		Fabricante fab = null;
		
		if(rs.next()) {
			fab = new Fabricante();
			fab.setIdFabricante(rs.getLong("idFabricante"));
			fab.setNome(rs.getString("nome"));
			
		}
		
		
		return fab;
		
	}
	
	public ArrayList<Fabricante> getAllFabricantes()throws SQLException,
		ClassNotFoundException{
		
		String sql = "SELECT idFabricante, nome FROM fabricante";
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Fabricante> fabricantes = new ArrayList<>();
		
		while(rs.next()){
			Fabricante f = new Fabricante();
			f.setIdFabricante(rs.getLong("idFabricante"));
			f.setNome(rs.getString("nome"));
			fabricantes.add(f);
		}
		
		return fabricantes;
	}
	
	public ArrayList<Fabricante> getFabricantePorNome(Fabricante f)
			throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT idFabricante, nome FROM fabricante " +
					"WHERE nome LIKE ?";
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setString(1, "%" + f.getNome() + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Fabricante> fabricantes = new ArrayList<>();
		
		while(rs.next()) {
			Fabricante fab = new Fabricante();
			fab.setIdFabricante(rs.getLong("idFabricante"));
			fab.setNome(rs.getString("nome"));
		}
		return fabricantes;
		
		
	}

}
