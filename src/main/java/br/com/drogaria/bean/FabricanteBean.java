package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}

	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO fdao = new FabricanteDAO();
			itens = fdao.getAllFabricantes();
			
		} catch (ClassNotFoundException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemSucesso(e.getMessage());

		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO fdao = new FabricanteDAO();
			fdao.salvar(fabricante);

			itens = fdao.getAllFabricantes();
			
			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com Sucesso!");

		} catch (ClassNotFoundException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		FabricanteDAO fdao = new FabricanteDAO();
		try {
			fdao.excluir(fabricante);
			itens = fdao.getAllFabricantes();

			
			JSFUtil.adicionarMensagemSucesso("Fabricante excluído com sucesso");
		} catch (ClassNotFoundException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

	public void editar() {
		try {
			FabricanteDAO fdao = new FabricanteDAO();
			fdao.alterar(fabricante);

			itens = fdao.getAllFabricantes();
			

			JSFUtil.adicionarMensagemSucesso("Fabricante atualizado com sucesso!");
		} catch (ClassNotFoundException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro(e.getMessage());
			e.printStackTrace();
		}

	}

}
