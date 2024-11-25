import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Book book1 = new Book("O Beco", "Junji Ito", 1);
        Book book2 = new Book("Frankstein", "Mary Shelley", 2);
        Book book3 = new Book("O Médico e o Monstro", "Robert L. Stevenson", 3);
        Book book4 = new Book("A Metamorfose", "Franz Kafka", 4);
        Book book5 = new Book("A Arte da Guerra", "Sun Tzu", 5);
        Book book6 = new Book("A Ilha do Tesouro", "Robert L. Stevenson", 6);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);


        System.out.println("\t---Bem Vindo a BiblioTheca---");
        int input;
        do {
            System.out.println("1. Entrar como administrador");
            System.out.println("2. Entrar como usuário");
            System.out.println("3. Fechar");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.printf("Digite a senha: ");
                    String password = scanner.nextLine();
                    if (password.equals("Senha123")) {
                        Methods.menuAdm(books);
                    }
                    else
                        System.out.println("Senha incorreta!");
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (input != 3);


        System.out.println("-Software made by: Mateus de Barros");

    }
}