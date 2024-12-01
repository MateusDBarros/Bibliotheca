import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> booklist = new ArrayList<>();
        ArrayList<Reader> borrowedBooks = new ArrayList<>();
        ArrayList<Reader> readers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        Book book1 = new Book("O Beco", "Junji Ito", 1);
        Book book2 = new Book("Frankstein", "Mary Shelley", 2);
        Book book3 = new Book("O Médico e o Monstro", "Robert L. Stevenson", 3);
        Book book4 = new Book("A Metamorfose", "Franz Kafka", 4);
        Book book5 = new Book("A Arte da Guerra", "Sun Tzu", 5);
        Book book6 = new Book("A Ilha do Tesouro", "Robert L. Stevenson", 6);
        booklist.add(book1);
        booklist.add(book2);
        booklist.add(book3);
        booklist.add(book4);
        booklist.add(book5);
        booklist.add(book6);

        readers.add(new Reader("Mateus", "mateusDbarros", "1357", booklist));


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
                    System.out.println();
                    System.out.printf("Digite a senha: ");
                    String password = scanner.nextLine();
                    if (password.equals("Senha123")) {
                        Methods.menuAdm(booklist);
                    }
                    else
                        System.out.println("Senha incorreta!");
                    break;

                case 2:
                    int choice;
                    System.out.println();
                    System.out.println();
                    do {
                        System.out.println("1. Criar uma conta.");
                        System.out.println("2. Entrar.");
                        System.out.println("3. Voltar");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.printf("Digite o seu nome: ");
                                String name = scanner.nextLine();
                                System.out.printf("Digite seu login: ");
                                String login =  scanner.nextLine();
                                System.out.println("Digite a senha de sua conta: ");
                                String Rpassword = scanner.nextLine();
                                readers.add(new Reader(name, login, Rpassword, booklist));
                                System.out.println("Conta criada com sucesso");
                                System.out.println();
                                break;

                            case 2:
                                System.out.printf("Entre seu login: ");
                                String Rlogin = scanner.nextLine();
                                int readerIndex = Reader.search(readers, Rlogin);
                                if (readerIndex == -2)
                                    System.out.println("Senha incorreta");
                                else if (readerIndex == -1)
                                    System.out.println("Conta não encontrada.");
                                else
                                    Reader.menu(readers, booklist, readerIndex);
                                break;

                            case 3:
                                System.out.println("Voltando ao menu principal");
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opção invalida!");
                                break;
                        }
                    } while (choice != 3);
                    break;

                case 3:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (input != 3);


        System.out.println("\t--Software made by: Mateus de Barros");

    }
}
