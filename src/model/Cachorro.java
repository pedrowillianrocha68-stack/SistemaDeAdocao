package model;

public class Cachorro extends Animal{
	
	public Cachorro(int id, String nome, int idade) {
		super(id,nome,idade);
	}
    @Override
	public String emitirSom() {
    	return "Au Au!";
    }
}
