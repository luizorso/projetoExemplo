package br.com.drogaria.domain;

public class Produto {
	private Long idProduto;
	private String nome;
	private int estoque;
	private Double preco;
	private Fabricante fabricante = new Fabricante();
	
	
	public Produto() {
		
	}


	public Long getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getEstoque() {
		return estoque;
	}


	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}


	@Override
	public String toString() {
		return "Código do Produto: " + this.getIdProduto() + 
				"\nNome do Produto " + this.getNome() +
				"\nEstoque : " + this.getEstoque() + 
				"\nPreco: " + this.getPreco() +
				"\nCódigo do Fabricante: " + this.getFabricante().getIdFabricante() +
				"\nNome do Fabricante: " + this.getFabricante().getNome();
	}
	
	

}
