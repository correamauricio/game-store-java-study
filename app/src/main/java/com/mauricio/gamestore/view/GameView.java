package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.GameController;
import com.mauricio.gamestore.model.entity.Game;

import java.util.List;
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

    public void displayAllGames() {
        List<Game> games = gameController.getAllGames();

        System.out.println("\n-- LISTA DE TODOS OS JOGOS --");

        if (games.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.printf("%-20s | %-15s | %-10s | %-15s\n", "Título", "Gênero", "Preço", "Categoria");
            System.out.println("-------------------------------------------------------------------------");
            for (Game game : games) {
                System.out.printf("%-20s | %-15s | R$ %-7.2f | %-15s\n",
                        game.getTitle(),
                        game.getGender(),
                        game.getPrice(),
                        game.getCategory().getTitle());
            }
        }
    }
}
