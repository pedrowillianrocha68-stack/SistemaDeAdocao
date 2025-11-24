package view;

import model.Animal;
import model.Adotante;
import model.Adocao;
import repository.PersistenciaAnimal;
import repository.PersistenciaAdotante;
import repository.PersistenciaAdocao;
import service.AnimalService;
import service.AdotanteService;
import service.AdocaoService;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args){
			    
        PersistenciaAnimal animalRepository = new AnimalRepository();
        PersistenciaAdotante adotanerepository= new AdotanteRepository();
        PersistenciaAdocao adocaoRepository = new PersistenciaAdocao();
        


        AnimalService animalService = new AnimalService(animalRepository);
        AdotanteService adotanteService = new AdotanteService(adotanteRepository);
        AdocaoService adocaoService = new AdocaoService(adocaoRepository, animalService, adotanteService);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Cadastrar Adotante");
            System.out.println("3. Realizar Adoção");
            System.out.println("4. Listar Animais");
            System.out.println("5. Listar Adotantes");
            System.out.println("6. Listar Adoções");
            System.out.println("7. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    
                    System.out.println("Nome do Animal:");
                    String nomeAnimal = scanner.nextLine();
                    System.out.println("Tipo do Animal (Cachorro/Gato):");
                    String tipoAnimal = scanner.nextLine();

                    Animal animal;
                    if (tipoAnimal.equalsIgnoreCase("Cachorro")) {
                        animal = new Cachorro(nomeAnimal);
                    } else if (tipoAnimal.equalsIgnoreCase("Gato")) {
                        animal = new Gato(nomeAnimal);
                    } else {
                        System.out.println("Tipo de animal inválido.");
                        break;
                    }

                    animalService.cadastrarAnimal(animal);
                    break;
                case 2:
                    
                    System.out.println("Nome do Adotante:");
                    String nomeAdotante = scanner.nextLine();
                    Adotante adotante = new Adotante(nomeAdotante);
                    adotanteService.cadastrarAdotante(adotante);
                    break;
                case 3:
                    
                    System.out.println("ID do Animal:");
                    int idAnimal = scanner.nextInt();
                    System.out.println("ID do Adotante:");
                    int idAdotante = scanner.nextInt();
                    scanner.nextLine(); 

                    try {
                        adocaoService.realizarAdocao(idAnimal, idAdotante);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    
                    animalService.listarAnimais().forEach(System.out::println);
                    break;
                case 5:
                    
                    adotanteService.listarAdotantes().forEach(System.out::println);
                    break;
                case 6:
                    
                    adocaoService.listarAdocoes().forEach(System.out::println);
                    break;
                case 7:
                    
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}