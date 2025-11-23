package model; 

public  abstract class Animal implements CuidadosEspeciais {
   private String nome;
   private int idade;
   private boolean vacinado;
   private boolean vermifugado;
   private boolean adocao;
 
public Animal(String nome,int idade) { 
	this.setNome(nome); 
	this.setIdade(idade);
}
public int getIdade() {
	return idade;
}

public void setIdade(int idade) {
	this.idade = idade;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}
public boolean isVacinado() {
	return vacinado;
}
public boolean isVermifugado(){
	return vermifugado;
}
public boolean vacinar() {
	if (!vacinado) {
		vacinado = true;
		return  true;
	}
	return false;
}
public boolean vermifugar() {
	if (!vermifugado) {
		vermifugado = true;
		return true;
	}
	return false;
}
public boolean isAdocao() {
	return adocao;
}


public void setAdocao(boolean adocao) {
	this.adocao = adocao;
}

public abstract String emitirSom();
}

