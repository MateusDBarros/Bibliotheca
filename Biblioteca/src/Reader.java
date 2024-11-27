import java.util.ArrayList;

public class Reader  extends Methods {

    private String name;
    private String login;
    private String password;
    private ArrayList<Book> books;



    public Reader (String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.books = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    public static int search(ArrayList<Reader> readers, String login) {
        if (readers == null) {
            System.out.println("Nenhuma conta registrada no banco de dados");
            return 0;
        }
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getLogin().equals(login)) {
                return i;
            }
        }
        return -1;
    }

    public static void menu(int index) {
        int input;
        do {
            System.out.println();
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Listar livros disponiveis");
            System.out.println("3. Ver meus livros");
            System.out.println("4. Devolver um livro");
            System.out.println("5. Voltar");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (input != 5);
    }
}
