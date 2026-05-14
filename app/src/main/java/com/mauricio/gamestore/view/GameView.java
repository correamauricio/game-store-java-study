package com.mauricio.gamestore.view;

import com.mauricio.gamestore.controller.GameController;
import com.mauricio.gamestore.model.dto.request.GameRequestDTO;
import com.mauricio.gamestore.model.dto.response.GameResponseDTO;

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

        GameRequestDTO request = new GameRequestDTO(title, gender, categoryId, price);
        String message = gameController.addGame(request);
        System.out.println(message);
    }

    public void displayAllGames() {
        List<GameResponseDTO> games = gameController.getAllGames();

        System.out.println("\n-- LISTA DE TODOS OS JOGOS --");

        if (games.isEmpty()) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.printf("%-5s | %-20s | %-15s | %-10s | %-15s\n", "ID", "Título", "Gênero", "Preço", "Categoria");
            System.out.println("-----------------------------------------------------------------------------------");
            for (GameResponseDTO game : games) {
                System.out.printf("%-5d | %-20s | %-15s | R$ %-7.2f | %-15s\n",
                        game.getId(),
                        game.getTitle(),
                        game.getGender(),
                        game.getPrice(),
                        game.getCategoryTitle());
            }
        }
    }

    public void editGame() {
        System.out.println("\n-- EDIÇÃO DE JOGO --");
        displayAllGames();

        System.out.print("\nDigite o ID do jogo que deseja editar: ");
        int id = Integer.parseInt(scanner.nextLine());

        GameResponseDTO game = gameController.getGameById(id);
        if (game == null) {
            System.out.println("Erro: Jogo não encontrado.");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual.");

        System.out.print("Título [" + game.getTitle() + "]: ");
        String title = scanner.nextLine();
        if (title.trim().isEmpty()) title = game.getTitle();

        System.out.print("Gênero [" + game.getGender() + "]: ");
        String gender = scanner.nextLine();
        if (gender.trim().isEmpty()) gender = game.getGender();

        System.out.print("Preço [" + game.getPrice() + "]: ");
        String priceStr = scanner.nextLine();
        double price = priceStr.trim().isEmpty() ? game.getPrice() : Double.parseDouble(priceStr);

        GameCategoryView categoryView = new GameCategoryView();
        categoryView.displayAllCategories();
        System.out.print("Escolha o ID da categoria [" + game.getCategoryId() + "]: ");
        String categoryIdStr = scanner.nextLine();
        int categoryId = categoryIdStr.trim().isEmpty() ? game.getCategoryId() : Integer.parseInt(categoryIdStr);

        GameRequestDTO request = new GameRequestDTO(title, gender, categoryId, price);
        String message = gameController.updateGame(id, request);
        System.out.println(message);
    }
    
    public void findGameById() {
        System.out.println("\n-- BUSCAR JOGO POR ID --");
        System.out.print("Digite o ID do jogo: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            GameResponseDTO game = gameController.getGameById(id);

            if (game != null) {
                System.out.println("\nJogo encontrado:");
                System.out.println("ID: " + game.getId());
                System.out.println("Título: " + game.getTitle());
                System.out.println("Gênero: " + game.getGender());
                System.out.printf("Preço: R$ %.2f\n", game.getPrice());
                System.out.println("Categoria: " + game.getCategoryTitle());
            } else {
                System.out.println("Jogo com ID " + id + " não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID inválido. Por favor, digite um número.");
        }
    }
}
