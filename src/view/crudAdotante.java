package model;

public abstract class Adotante {
    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Adotante(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Adotante {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;

public class AdotanteRepository {

    private List<Adotante> adotantes = new ArrayList<>();
    private int nextId = 1;

    public Adotante criar(String nome, String telefone, String email) {
        Adotante a = new Adotante(nextId++, nome, telefone, email);
        adotantes.add(a);
        return a;
    }

    public List<Adotante> listar() {
        return adotantes;
    }

    public Adotante buscarPorId(int id) {
        return adotantes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean atualizar(int id, String nome, String telefone, String email) {
        Adotante a = buscarPorId(id);
        if (a != null) {
            a.setNome(nome);
            a.setTelefone(telefone);
            a.setEmail(email);
            return true;
        }
        return false;
    }

    public boolean deletar(int id) {
        return adotantes.removeIf(a -> a.getId() == id);
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdotanteRepository repo = new AdotanteRepository();

        while (true) {
            System.out.println("\n=== SISTEMA DE ADOÇÃO – CRUD ADOTANTE ===");
            System.out.println("1 - Criar adotante");
            System.out.println("2 - Listar adotantes");
            System.out.println("3 - Buscar adotante por ID");
            System.out.println("4 - Atualizar adotante");
            System.out.println("5 - Deletar adotante");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int op = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (op) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    Adotante novo = repo.criar(nome, telefone, email);
                    System.out.println("Criado com sucesso: " + novo);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE ADOTANTES ---");
                    for (Adotante a : repo.listar()) {
                        System.out.println(a);
                    }
                    break;

                case 3:
                    System.out.print("ID: ");
                    int idBusca = sc.nextInt();
                    Adotante encontrado = repo.buscarPorId(idBusca);
                    System.out.println(encontrado != null ? encontrado : "Não encontrado.");
                    break;

                case 4:
                    System.out.print("ID do adotante: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nomeNovo = sc.nextLine();

                    System.out.print("Novo telefone: ");
                    String telNovo = sc.nextLine();

                    System.out.print("Novo email: ");
                    String emailNovo = sc.nextLine();

                    boolean atualizado = repo.atualizar(idAtualizar, nomeNovo, telNovo, emailNovo);
                    System.out.println(atualizado ? "Atualizado com sucesso." : "Adotante não encontrado.");
                    break;

                case 5:
                    System.out.print("ID do adotante: ");
                    int idDel = sc.nextInt();
                    boolean removido = repo.deletar(idDel);
                    System.out.println(removido ? "Removido com sucesso." : "Adotante não encontrado.");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
