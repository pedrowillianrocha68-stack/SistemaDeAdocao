package sistema;

import java.time.LocalDate;

public class Adocao {
    private Adotante adotante;
    private Animal animal;
    private LocalDate data;

    public Adocao(Adotante adotante, Animal animal) {
        this.adotante = adotante;
        this.animal = animal;
        this.data = LocalDate.now();
    }

    public Adotante getAdotante() { return adotante; }
    public Animal getAnimal() { return animal; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return "Adoção: " + animal.getNome() +
               " → Adotante: " + adotante.getNome() +
               " → Data: " + data;
    }
}
public static void registrarAdocao(int idAnimal, int idAdotante) {
    Animal animal = buscarAnimal(idAnimal);
    Adotante adotante = buscarAdotante(idAdotante);

    if (animal == null || adotante == null) {
        System.out.println("Erro: animal ou adotante não existe.");
        return;
    }

    if (animal.isAdotado()) {
        System.out.println("Erro: este animal já foi adotado.");
        return;
    }

    animal.setAdotado(true);
    adocoes.add(new Adocao(adotante, animal));

    System.out.println("Adoção registrada com sucesso!");
}