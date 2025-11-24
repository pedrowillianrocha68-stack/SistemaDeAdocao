package service;

import java.util.ArrayList;
import java.util.List;
import model.Adotante;

public class AdotanteService {
	
	private List<Adotante> adotantes = new ArrayList<>();
	
	public void cadastrar(Adotante adotante) {
		adotantes.add(adotante);
	}
	public List<Adotante> listar(){
		return adotantes;
	}
	public Adotante buscarPorIndex(int index) {
		if (index >= 0 && index < adotantes.size()) {
		return adotantes.get(index);
	}
		return null;
	}
	public boolean atualizar(int index, Adotante novoAdotante) {
		if (index >= 0 && index < adotantes.size()) {
			adotantes.set(index, novoAdotante);
			return true;
		}
		    return false;
	}
	public boolean remover(int index) {
		if (index >= 0 && index < adotantes.size()) {
			adotantes.remove(index);
			return true;
		}
		return false;
	}
	public int quantidadeAdotantes() {
		return adotantes.size();
	}
}
