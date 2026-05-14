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
            System.out.println("5. Cadastrar novo Cliente");
            System.out.println("6. Listar todos os Clientes");
            System.out.println("7. Buscar Cliente por ID");
            System.out.println("8. Editar Cliente");
            System.out.println("9. Listar todas as Compras");
            System.out.println("10. Buscar Compra por ID");
            System.out.println("11. Editar Compra");
            System.out.println("12. Registrar nova Compra");
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
                    CustomerView customerRegView = new CustomerView();
                    customerRegView.registerCustomer();
                    break;
                case "6":
                    CustomerView customerView = new CustomerView();
                    customerView.displayAllCustomers();
                    break;
                case "7":
                    CustomerView searchCustomerView = new CustomerView();
                    searchCustomerView.findCustomerById();
                    break;
                case "8":
                    CustomerView editCustomerView = new CustomerView();
                    editCustomerView.editCustomer();
                    break;
                case "9":
                    PurchaseView purchaseView = new PurchaseView();
                    purchaseView.displayAllPurchases();
                    break;
                case "10":
                    PurchaseView searchPurchaseView = new PurchaseView();
                    searchPurchaseView.searchPurchaseById();
                    break;
                case "11":
                    PurchaseView editPurchaseView = new PurchaseView();
                    editPurchaseView.editPurchase();
                    break;
                case "12":
                    PurchaseView registerPurchaseView = new PurchaseView();
                    registerPurchaseView.registerPurchase();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }
}
