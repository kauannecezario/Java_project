package com.librarysystem;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Book> books = new HashMap<>();

    public void registerUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Usuário já existe.");
        } else {
            users.put(username, new User(username, password));
            System.out.println("Usuário registrado com sucesso.");
        }
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void addBook(String title, String author, String isbn) {
        if (books.containsKey(isbn)) {
            System.out.println("Livro já cadastrado.");
        } else {
            books.put(isbn, new Book(title, author, isbn));
            System.out.println("Livro adicionado com sucesso.");
        }
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Registrar Usuário");
            System.out.println("2. Login");
            System.out.println("3. Adicionar Livro");
            System.out.println("4. Consultar Livro");
            System.out.println("5. Sair");

            int option = scanner.nextInt();
            scanner.nextLine(); 
            switch (option) {
                case 1:
                    System.out.println("Digite o nome de usuário:");
                    String username = scanner.nextLine();
                    System.out.println("Digite a senha:");
                    String password = scanner.nextLine();
                    system.registerUser(username, password);
                    break;

                case 2:
                    System.out.println("Digite o nome de usuário:");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Digite a senha:");
                    String loginPassword = scanner.nextLine();
                    if (system.login(loginUsername, loginPassword)) {
                        System.out.println("Login bem-sucedido!");
                    } else {
                        System.out.println("Nome de usuário ou senha incorretos.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o título do livro:");
                    String title = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String author = scanner.nextLine();
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    system.addBook(title, author, isbn);
                    break;

                case 4:
                    System.out.println("Digite o título do livro para consulta:");
                    String searchTitle = scanner.nextLine();
                    system.searchBook(searchTitle);
                    break;

                case 5:
                    exit = true;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
 
