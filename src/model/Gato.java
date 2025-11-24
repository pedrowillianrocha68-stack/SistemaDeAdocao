package model;

public class Gato extends Animal{
	
	public Gato(int id, String nome, int idade) {
		super(id,nome, idade);
	}
	@Override
	public String emitirSom() {
		return "Miau";
	}
}
