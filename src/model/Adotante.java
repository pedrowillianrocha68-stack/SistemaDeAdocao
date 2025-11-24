package model;

import java.util.List;
import java.util.ArrayList;

public class Adotante {
   private String nome; 
   private int idade; 
   private List<Animal> animaisAdotados;
   
  public Adotante(String nome, int idade){ 
    	 this.nome = nome; 
    	 this.idade = idade; 
    	 this.animaisAdotados = new ArrayList<>();
     }
      public String getNome() { 
    	  return nome;
      }
      public void setNome(String nome) { 
    	  this.nome = nome;
      }
      public int getIdade() { 
    	  return idade; 
      }
      public void setIdade(int idade) { 
    	  this.idade = idade;
      }

	public List<Animal> getAnimaisadotados() {
		return animaisAdotados;
	}

	  public void setAnimaisadotados(List<Animal> animaisadotados) {
		this.animaisAdotados = animaisadotados;
	  }
	  public List<Animal> getAnimaisAdotados(){
    	  return animaisAdotados;
      }
      
}
