package com.mauricio.gamestore.view;

import java.util.Scanner;

public class MainView {
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n -- MENU DO SISTEMA --");
            System.out.println("1. Listar todos os Jogos");
            System.out.println("2. Buscar Jogo por ID");
            System.out.println("3. Cadastrar novo Jogo");
            System.out.println("4. Editar Jogo");
            
            System.out.println("\n5. Listar todos os Clientes");
            System.out.println("6. Buscar Cliente por ID");
            System.out.println("7. Cadastrar novo Cliente");
            System.out.println("8. Editar Cliente");

            System.out.println("\n9. Listar todas as Compras");
            System.out.println("10. Buscar Compra por ID");
            System.out.println("11. Registrar nova Compra");
            System.out.println("12. Editar Compra");

            System.out.println("\n0. Sair");
            System.out.print("Escolha uma opção: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    new GameView().displayAllGames();
                    break;
                case "2":
                    new GameView().findGameById();
                    break;
                case "3":
                    new GameView().registerGame();
                    break;
                case "4":
                    new GameView().editGame();
                    break;
                case "5":
                    new CustomerView().displayAllCustomers();
                    break;
                case "6":
                    new CustomerView().findCustomerById();
                    break;
                case "7":
                    new CustomerView().registerCustomer();
                    break;
                case "8":
                    new CustomerView().editCustomer();
                    break;
                case "9":
                    new PurchaseView().displayAllPurchases();
                    break;
                case "10":
                    new PurchaseView().searchPurchaseById();
                    break;
                case "11":
                    new PurchaseView().registerPurchase();
                    break;
                case "12":
                    new PurchaseView().editPurchase();
                    break;

                case "0":
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
