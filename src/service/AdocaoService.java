package service;

import exception.AnimalIndisponivelException;
import exception.LimiteAdocoesException;

import java.util.ArrayList;
import java.util.List;

import model.Adotante;
import model.Animal;
import model.Adocao;

public class AdocaoService {
	
	private List<Adocao> adocoes = new ArrayList<>();
		
	private AnimalService animalService;
	private AdotanteService adotanteService;
	
	public AdocaoService (AnimalService animalService, AdotanteService adotanteService) {
		this.animalService = animalService;
		this.adotanteService  = adotanteService;
	    }
	public boolean registrar (int idAnimal, int idAdotante) {
		Animal animal = animalService.buscarPorIndex(idAnimal);
		Adotante adotante = adotanteService.buscarPorIndex(idAdotante);
		
		if (animal == null || adotante == null) {
			System.out.println("ERRO: animal ou adotante não existem");
			return false;
		}
		if (!animal.isAdocao()) {
			throw new AnimalIndisponivelException("ERRO: o animal" + animal.getNome() + "está indisponível");
		}
		int quantidade = quantidadeDeAnimaisAdotante(adotante);
	    
	    if (quantidade >= 3) {
		throw new LimiteAdocoesException("ERRO: o adotante"+ adotante.getNome()+"já tem 3 animais.");
	    }
	    Adocao ad = new Adocao(adotante, animal);
	    adocoes.add(ad);
	    
	    animal.setAdocao(false);
	    
	    System.out.println("Adoção registrada com sucesso");
	    return true;
	   }
		private int quantidadeDeAnimaisAdotante(Adotante adotante) {
			int count = 0;
			for (Adocao a : adocoes) {
				if (a.getAdotante().equals(adotante)) {
					count ++;
				}
			} 
			return count;
		}
		public List<Adocao> listar(){
			return adocoes;
		}
		public boolean remover(int index) {
			if(index>=0 && index < adocoes.size()) {
				Adocao a = adocoes.get(index);
				a.getAnimal().setAdocao(true);
				adocoes.remove(index);
				return true;
			}
			return false;
		}
	
}