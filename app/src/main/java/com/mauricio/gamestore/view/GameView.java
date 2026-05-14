package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.GameController;

import java.util.Scanner;

public class GameView {
    private final GameController gameController;
    private final Scanner scanner;

    public GameView() {
        this.gameController = new GameController();
        this.scanner = new Scanner(System.in);
    }

    public void registerGame() {
        System.out.println("\n-- CADASTRO DE NOVO JOGO --");

        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Gênero: ");
        String gender = scanner.nextLine();

        System.out.print("Preço: ");
        double price = Double.parseDouble(scanner.nextLine());

        GameCategoryView categoryView = new GameCategoryView();
        categoryView.displayAllCategories();

        System.out.print("\nEscolha o ID da categoria: ");
        int categoryId = Integer.parseInt(scanner.nextLine());

        String message = gameController.addGame(title, gender, categoryId, price);
        System.out.println(message);
    }
}
