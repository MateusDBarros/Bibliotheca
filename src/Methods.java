import java.util.ArrayList;
import java.util.Scanner;
public class Methods {


    static Scanner scanner = new Scanner(System.in);
    //Função para Exibir todos  os livros registrados
    public static void showAll(ArrayList<Book> books) {
        bubbleSort(books);
        System.out.printf("%-3s | %-20s | %-20s | %-20s\n", "ID", "Titulo", "Autor", "Status");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isRented() == false) {
                System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(i).getId(), books.get(i).getTitle(), books.get(i).getAuthor(), "Livre");
            }
            else {
                System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(i).getId(), books.get(i).getTitle(), books.get(i).getAuthor(), "Alugado");
            }
        }
    }

    public static void show(ArrayList<Book> books, int index) {
        System.out.printf("%-3s | %-20s | %-20s | %-20s\n", "ID", "Titulo", "Autor", "Status");
        System.out.println("---------------------------------------------------");
        if (books.get(index).isRented() == false) {
            System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(index).getId(), books.get(index).getTitle(), books.get(index).getAuthor(), "Livre");
        }
        else {
            System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(index).getId(), books.get(index).getTitle(), books.get(index).getAuthor(), "Alugado");
        }

    }

    //Função para ordenar o livros por nome
    public static void bubbleSort(ArrayList<Book> books) {
        Book temp;
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j + 1).getTitle()) > 0) {
                    temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    public static void adm() {

    }

    public static void update(String title, ArrayList<Book> books) {
        for (int  i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                System.out.println("O que deseja editar?");
                int input;
                do {
                    System.out.println("1. Titulo");
                    System.out.println("2. Autor");
                    System.out.println("3. Voltar");
                    input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            System.out.printf("Digite o novo titulo: ");
                            String newTitle = scanner.nextLine();
                            books.get(i).setTitle(newTitle);
                            System.out.println("Titulo alterado com sucesso");
                            show(books, i);
                            break;

                        case 2:
                            System.out.printf("Digite o novo autor: ");
                            String newAuthor = scanner.nextLine();
                            books.get(i).setTitle(newAuthor);
                            System.out.println("Autor alterado com sucesso");
                            show(books, i);
                            break;

                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                } while (input != 3);
            }
        }
        System.out.println("Titulo não encontrado");
    }

    public static void delete(String input, ArrayList<Book> books) {
        if (input.equals("sair")) {
            System.out.println("Retornando ao menu anterior!");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            if (input.equals(books.get(i).getTitle())) {
                System.out.printf("Voce tem certeza que deseja excluir %s ('y'/'n')?\n", books.get(i).getTitle());
                char choice = scanner.next().charAt(0);
                if (choice == 'n') {
                    System.out.println("Ação cancelada");
                    return;
                } else if (choice == 'y') {
                    books.remove(i);
                    System.out.println("Livro removido com sucesso, bye bye");
                }
                else {
                    System.out.println("Opção invalida");
                    return;
                }
            }
        }
    }

    public static void menuAdm(ArrayList<Book> books) {
        int input;
        do {
            titulo();
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Editar informações de um livro");
            System.out.println("4. Apagar um livro");
            System.out.println("5. Voltar");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.printf("Digite o titulo do livro: ");
                    String title = scanner.nextLine();
                    System.out.printf("Digite o autor do livro: ");
                    String author =  scanner.nextLine();
                    books.add(new Book(title, author, books.size() + 1));
                    System.out.println("Livro adicionado com sucesso");
                    System.out.println();
                    break;

                case 2:
                    showAll(books);
                    System.out.println();
                    break;

                case 3:
                    System.out.printf("Qual livro deseja editar? ");
                    String update = scanner.nextLine();
                    update(update, books);
                    break;

                case 4:
                    System.out.printf("Qual livro deseja excluir(Digite 'sair' para cancelar)? ");
                    String delete = scanner.nextLine();
                    delete(delete, books);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (input != 5);
    }

    public static void titulo() {

        int i = 0;
        while (i < 6) {
            System.out.println();
            i++;
        }
        System.out.println("\t--- Bem vindo! ---");
        System.out.println();
    }
}
import java.util.ArrayList;
import java.util.Scanner;
public class Methods {


    static Scanner scanner = new Scanner(System.in);
    //Função para Exibir todos  os livros registrados
    public static void showAll(ArrayList<Book> books) {
        bubbleSort(books);
        System.out.printf("%-3s | %-20s | %-20s | %-20s\n", "ID", "Titulo", "Autor", "Status");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isRented() == false) {
                System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(i).getId(), books.get(i).getTitle(), books.get(i).getAuthor(), "Livre");
            }
            else {
                System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(i).getId(), books.get(i).getTitle(), books.get(i).getAuthor(), "Alugado");
            }
        }
    }

    public static void show(ArrayList<Book> books, int index) {
        System.out.printf("%-3s | %-20s | %-20s | %-20s\n", "ID", "Titulo", "Autor", "Status");
        System.out.println("---------------------------------------------------");
        if (books.get(index).isRented() == false) {
            System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(index).getId(), books.get(index).getTitle(), books.get(index).getAuthor(), "Livre");
        }
        else {
            System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(index).getId(), books.get(index).getTitle(), books.get(index).getAuthor(), "Alugado");
        }

    }

    //Função para ordenar o livros por nome
    public static void bubbleSort(ArrayList<Book> books) {
        Book temp;
        for (int i = 0; i < books.size(); i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j + 1).getTitle()) > 0) {
                    temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    public static void adm() {

    }

    public static void update(String title, ArrayList<Book> books) {
        for (int  i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                System.out.println("O que deseja editar?");
                int input;
                do {
                    System.out.println("1. Titulo");
                    System.out.println("2. Autor");
                    System.out.println("3. Voltar");
                    input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            System.out.printf("Digite o novo titulo: ");
                            String newTitle = scanner.nextLine();
                            books.get(i).setTitle(newTitle);
                            System.out.println("Titulo alterado com sucesso");
                            show(books, i);
                            break;

                        case 2:
                            System.out.printf("Digite o novo autor: ");
                            String newAuthor = scanner.nextLine();
                            books.get(i).setTitle(newAuthor);
                            System.out.println("Autor alterado com sucesso");
                            show(books, i);
                            break;

                        default:
                            System.out.println("Opção invalida");
                            break;
                    }
                } while (input != 3);
            }
        }
        System.out.println("Titulo não encontrado");
    }

    public static void delete(String input, ArrayList<Book> books) {
        if (input.equals("sair")) {
            System.out.println("Retornando ao menu anterior!");
            return;
        }

        for (int i = 0; i < books.size(); i++) {
            if (input.equals(books.get(i).getTitle())) {
                System.out.printf("Voce tem certeza que deseja excluir %s ('y'/'n')?\n", books.get(i).getTitle());
                char choice = scanner.next().charAt(0);
                if (choice == 'n') {
                    System.out.println("Ação cancelada");
                    return;
                } else if (choice == 'y') {
                    books.remove(i);
                    System.out.println("Livro removido com sucesso, bye bye");
                }
                else {
                    System.out.println("Opção invalida");
                    return;
                }
            }
        }
    }

    public static void menuAdm(ArrayList<Book> books) {
        int input;
        do {
            titulo();
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Editar informações de um livro");
            System.out.println("4. Apagar um livro");
            System.out.println("5. Voltar");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.printf("Digite o titulo do livro: ");
                    String title = scanner.nextLine();
                    System.out.printf("Digite o autor do livro: ");
                    String author =  scanner.nextLine();
                    books.add(new Book(title, author, books.size() + 1));
                    System.out.println("Livro adicionado com sucesso");
                    System.out.println();
                    break;

                case 2:
                    showAll(books);
                    System.out.println();
                    break;

                case 3:
                    System.out.printf("Qual livro deseja editar? ");
                    String update = scanner.nextLine();
                    update(update, books);
                    break;

                case 4:
                    System.out.printf("Qual livro deseja excluir(Digite 'sair' para cancelar)? ");
                    String delete = scanner.nextLine();
                    delete(delete, books);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    System.out.println();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (input != 5);
    }

    public static void titulo() {

        int i = 0;
        while (i < 6) {
            System.out.println();
            i++;
        }
        System.out.println("\t--- Bem vindo! ---");
        System.out.println();
    }
}
