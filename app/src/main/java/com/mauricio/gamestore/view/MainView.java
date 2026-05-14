package com.mauricio.gamestore.view;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n -- MENU DO SISTEMA --");
            System.out.println("1. Exibir Categorias de jogos");
            System.out.println("2. Cadastrar novo Jogo");
            System.out.println("3. Listar todos os Jogos");
            System.out.println("4. Editar Jogo");
            System.out.println("5. Listar todos os Clientes");
            System.out.println("6. Buscar Cliente por ID");
            System.out.println("7. Editar Cliente");
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
                case "3":
                    GameView listGamesView = new GameView();
                    listGamesView.displayAllGames();
                    break;
                case "4":
                    GameView editGameView = new GameView();
                    editGameView.editGame();
                    break;
                case "5":
                    CustomerView customerView = new CustomerView();
                    customerView.displayAllCustomers();
                    break;
                case "6":
                    CustomerView searchCustomerView = new CustomerView();
                    searchCustomerView.findCustomerById();
                    break;
                case "7":
                    CustomerView editCustomerView = new CustomerView();
                    editCustomerView.editCustomer();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
