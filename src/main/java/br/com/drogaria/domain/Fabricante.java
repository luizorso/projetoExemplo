package br.com.drogaria.domain;

public class Fabricante {
	private Long idFabricante;
	private String nome;
	
	public Fabricante() {
		
	}

	public Long getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Long idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Código do Fabricante: " + this.getIdFabricante() + 
				"\nNome do Fabricnate: " + this.getNome();
		}
	
	
}
