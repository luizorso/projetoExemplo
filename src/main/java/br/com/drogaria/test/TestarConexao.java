package br.com.drogaria.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.drogaria.factory.ConexaoFactory;

public class TestarConexao {

	public static void main(String[] args) {
		try {
			Connection con = ConexaoFactory.conectar();
			
			JOptionPane.showMessageDialog(
					null, "A conexão com a base de dados foi efetuada com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null, "Erro ao conectar com a base de dados: " 
							+ e.getMessage());
		} 

	}

}
