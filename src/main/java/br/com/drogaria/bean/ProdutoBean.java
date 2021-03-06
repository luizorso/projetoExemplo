package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.JSFUtil;


@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	
	private ArrayList<Produto> itens;
	private ArrayList<Produto> itensFiltrados;
	
	private Produto produto;
	
	private ArrayList<Fabricante> comboFabricantes;

	public ArrayList<Produto> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produto> itens) {
		this.itens = itens;
	}
	
	
	
	public ArrayList<Produto> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ArrayList<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}

	public void setComboFabricantes(ArrayList<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}


	public void carregarListagem() {
		
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			itens = pdao.getAllProdutos();
	
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void prepararNovo() {
	try {
			produto = new Produto();
			FabricanteDAO fdao = new FabricanteDAO();
			comboFabricantes = fdao.getAllFabricantes();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void novo() {
	
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produto);
			itens = pdao.getAllProdutos();
			JSFUtil.adicionarMensagemSucesso("Produto Salvo com sucesso!");
		
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public void excluir() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produto);
			itens = pdao.getAllProdutos();
			JSFUtil.adicionarMensagemSucesso("Produto exclu?do com sucesso!");
			
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
