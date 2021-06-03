package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAO {
	
	public void salvar(Produto p)throws SQLException,
			ClassNotFoundException{
		String sql = "INSERT INTO produto " +
					"(nome, estoque, preco, idFabricante) " +
					"VALUES (?, ?, ?, ?)";
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setString(1, p.getNome());
		pstmt.setInt(2, p.getEstoque());
		pstmt.setDouble(3, p.getPreco());
		pstmt.setLong(4, p.getFabricante().getIdFabricante());
		
		pstmt.executeUpdate();
		
		
	}
	
	public void excluir(Produto p)throws SQLException, 
			ClassNotFoundException{
		
		String sql = "DELETE FROM produto WHERE idProduto = ?";
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setLong(1, p.getIdProduto());
		
		pstmt.executeUpdate();
		
		
	}
	
	public void alterar(Produto p)throws SQLException, 
		ClassNotFoundException{
		
		String sql = "UPDATE produto set nome = ?, estoque = ?, " + 
				"preco = ?, idFabricante = ? " + 
				"WHERE idProduto = ?";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		pstmt.setString(1, p.getNome());
		pstmt.setInt(2, p.getEstoque());
		pstmt.setDouble(3, p.getPreco());
		pstmt.setLong(4, p.getFabricante().getIdFabricante());
		
		pstmt.executeUpdate();
		
	}
	
	public ArrayList<Produto> getAllProdutos()throws SQLException, 
		ClassNotFoundException{
		
		String sql= "SELECT p.idProduto, p.nome, p.estoque, p.preco, " +
				"f.idFabricante, f.nome " +
				"FROM produto p INNER JOIN fabricante f " +
				"ON f.idFabricante = p.idFabricante";
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement pstmt = conexao.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Produto> produtos = new ArrayList<>();
		
		while(rs.next()) {
			Fabricante f = new Fabricante();
			f.setIdFabricante(rs.getLong("f.idFabricante"));
			f.setNome(rs.getString("f.nome"));
			Produto prod = new Produto();
			prod.setIdProduto(rs.getLong("p.idProduto"));
			prod.setNome(rs.getString("p.nome"));
			prod.setEstoque(rs.getInt("p.estoque"));
			prod.setPreco(rs.getDouble("p.preco"));
			prod.setFabricante(f);
			produtos.add(prod);
		}
		
		return produtos;
	}

}
