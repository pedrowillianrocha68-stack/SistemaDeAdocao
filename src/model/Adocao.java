package model;

public class Adocao {
  private Adotante adotante;
  private Animal animal;
  private String data;

public Adocao (Adotante adotante ,Animal animal) {
	this.setAdotante(adotante);
	this.setAnimal(animal);
	this.getAnimal().setAdocao(true);
    }

public Adotante getAdotante() {
	return adotante;
}

public void setAdotante(Adotante adotante) {
	this.adotante = adotante;
}

public Animal getAnimal() {
	return animal;
}

public void setAnimal(Animal animal) {
	this.animal = animal;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

@Override
public String toString() { 
	return " Adoção -> " + (adotante != null ? adotante.getNome() : "adotante desconhecido") +
			"adotou" + (animal != null ? animal.getNome() : "Animal desconhecido");
    }
}   
