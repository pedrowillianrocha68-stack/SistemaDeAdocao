package model;

public static void listarAdocoesPorAdotante(int idAdotante) {
    adocoes.stream()
            .filter(a -> a.getAdotante().getId() == idAdotante)
            .forEach(System.out::println);
}
Banco.listarAdocoesPorAdotante(1);
public static void listarAdocoesPorPeriodo(LocalDate inicio, LocalDate fim) {
    adocoes.stream()
            .filter(a -> !a.getData().isBefore(inicio) && !a.getData().isAfter(fim))
            .forEach(System.out::println);
}
Banco.listarAdocoesPorPeriodo(
	    LocalDate.of(2025, 1, 1),
	    LocalDate.of(2025, 12, 31)
	);
public static void listarTodasAdocoes() {
    adocoes.forEach(System.out::println);
}