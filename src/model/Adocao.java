package model;

import model.Adotante;
import model.Animal;

public class Adocao {
  private Adotante adotante;
  private Animal animal;

public Adocao(adotante adotante ,animal animal) {
	this.adotante = adotante;
	this.animal = animal;
	this.animal.setAdocao(true);
}
@Override
public String toString() { 
	return " Adoção -> " + Adotante.getNome() + " Adotou! " + Animal.getNome();
}
}   

