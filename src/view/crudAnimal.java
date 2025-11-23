package model;

public abstract class Animal {
    private int id;
    private String nome;
    private String especie;
    private int idade;

    public Animal(int id, String nome, String especie, int idade) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public int getIdade() { return idade; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setIdade(int idade) { this.idade = idade; }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Espécie: " + especie + " | Idade: " + idade;
    }
} 

import java.util.ArrayList;
import java.util.List;

public class AnimalDAO {
    private List<Animal> animais = new ArrayList<>();
    private int proximoId = 1;

    public Animal cadastrar(String nome, String especie, int idade) {
        Animal a = new Animal(proximoId++, nome, especie, idade);
        animais.add(a);
        return a;
    }

    public List<Animal> listar() {
        return animais;
    }

    public boolean atualizar(int id, String nome, String especie, int idade) {
        for (Animal a : animais) {
            if (a.getId() == id) {
                a.setNome(nome);
                a.setEspecie(especie);
                a.setIdade(idade);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return animais.removeIf(a -> a.getId() == id);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimalDAO dao = new AnimalDAO();

        while (true) {
            System.out.println("\n===== CRUD DE ANIMAIS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    dao.cadastrar(nome, especie, idade);
                    System.out.println("Animal cadastrado!");
                }

                case 2 -> {
                    System.out.println("\nLista de animais:");
                    for (Animal a : dao.listar()) {
                        System.out.println(a);
                    }
                }

                case 3 -> {
                    System.out.print("ID do animal a atualizar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Nova espécie: ");
                    String especie = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int idade = sc.nextInt();

                    if (dao.atualizar(id, nome, especie, idade)) {
                        System.out.println("Animal atualizado!");
                    } else {
                        System.out.println("Animal não encontrado!");
                    }
                }

                case 4 -> {
                    System.out.print("ID do animal a remover: ");
                    int id = sc.nextInt();
                    if (dao.remover(id)) {
                        System.out.println("Animal removido!");
                    } else {
                        System.out.println("Animal não encontrado!");
                    }
                }

                case 5 -> {
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

