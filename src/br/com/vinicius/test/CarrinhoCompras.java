package br.com.vinicius.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {

	private int id;
	private String nome;
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CarrinhoCompras(int id, String nome, Double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Item: " + nome + " Valor: " + valor; 
	}

	public static void main(String[] args) {

		Double valorTotalCompra = 0.0;
		DecimalFormat decimal = new DecimalFormat("#.##");
		List<CarrinhoCompras> compras = new ArrayList<CarrinhoCompras>();

		compras.add(new CarrinhoCompras(1, "batata", 3.25));
		compras.add(new CarrinhoCompras(2, "tomate", 9.29));
		compras.add(new CarrinhoCompras(3, "cenoura", 4.99));
		compras.add(new CarrinhoCompras(4, "agriao", 2.49));
		compras.add(new CarrinhoCompras(5, "chuchu", 3.99));
		
		ordenaLista(compras);
		
		for (int i = 0; i < compras.size(); i++) {
			valorTotalCompra += compras.get(i).getValor();
		}
		
		System.out.println("Valor total R$" + decimal.format(valorTotalCompra));

	}

	private static void ordenaLista(List<CarrinhoCompras> compras) {

		compras.stream()
			.sorted((p1, p2) -> p1.getValor().compareTo(p2.getValor()))
			.forEach(p -> System.out.println(p));

	}
}
