package com.mauricio.gamestore.view;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n -- MENU DO SISTEMA --");
            System.out.println("1. Exibir Categorias de jogos");
            System.out.println("2. Cadastrar novo Jogo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    GameCategoryView gameCategory = new GameCategoryView();
                    gameCategory.displayAllCategories();
                    break;
                case "2":
                    GameView gameView = new GameView();
                    gameView.registerGame();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
