package view;

import java.util.ArrayList;
import java.util.List;
import model.Animal;

public abstract class AnimalService {
	
	private List<Animal> animais = new ArrayList<>();
	
	public void cadastrar(Animal animal) {
		animais.add(animal);
	}
	public Animal buscarPorIndex(int index) {
		if (index >= 0 && index < animais.size()) {
			return animais.get(index);
		}
		return null;
	}
	public boolean  atualizar(int index, animal novoAnimal) {
		if (index >= 0 && index < animais.size()) {
			animais.set(index, novoAnimal);
			return true;
		}
		return false;
	}
	public boolean remover(int index) {
		if (index >= 0 && index < animal.size()) {
			animais.remove(index);
			return true;
		}
		return false;
	}
	public int quantidade() {
		return animais.size();
	}
	
}


