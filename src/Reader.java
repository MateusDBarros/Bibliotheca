import java.util.ArrayList;

public class Reader  extends Methods {

    private String name;
    private String login;
    private String password;
    private ArrayList<Book> borrowedBooks; //Livros emprestados
    private ArrayList<Book> booklist; //Livros de referencia





    public Reader (String name, String login, String password, ArrayList<Book> booklist){
        this.name = name;
        this.login = login;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
        this.booklist = booklist;
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

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public static int search(ArrayList<Reader> readers, String login) {
        if (readers == null) {
            System.out.println("Nenhuma conta registrada no banco de dados");
            return 0;
        }
        for (int i = 0; i < readers.size(); i++) {
            if (readers.get(i).getLogin().equals(login)) {
                System.out.printf("Digite sua senha: ");
                String password = scanner.nextLine();

                if (checkPass(readers, i, password) == true)
                    return i;
                else
                    return -2;
            }
        }
        return -1;
    }

    public static boolean checkPass(ArrayList<Reader> readers,int index, String password) {

        if (password.equals(readers.get(index).getPassword()))
            return true;


        return false;
    }

    public static void showAll(ArrayList<Book> books) {
        bubbleSort(books);
        System.out.printf("%-3s | %-20s | %-20s | %-20s\n", "ID", "Titulo", "Autor", "Status");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isRented() == false) {
                System.out.printf("%-3d | %-20s | %-20s | %-20s\n", books.get(i).getId(), books.get(i).getTitle(), books.get(i).getAuthor(), "Livre");
            }
        }
    }

    public static void myBooks(Reader currentReader) {
        System.out.println("Livros emprestados por " + currentReader.getName()+ ":");
        System.out.printf("%-3s | %-20s | %-20s \n", "ID", "Titulo", "Autor");
        System.out.println("----------------------------------------------------------");
        for (Book book : currentReader.getBorrowedBooks()) {
            System.out.printf("%-3d | %-20s | %-20s\n", book.getId(), book.getTitle(), book.getAuthor());
        }
    }

    public static void borrow (ArrayList<Book> books,ArrayList<Book> myBooks, int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                myBooks.add(books.get(i));
                System.out.println("Livro adicionado com sucesso!");
                books.get(i).setRented(true);
                return;
            }
        }
        System.out.println("Livro não encontrado");
    }

    public static void returnBook (ArrayList<Book> books,Reader currentReader, int id) {
        for (int i = 0; i <= currentReader.borrowedBooks.size(); i++) {
            if (id == currentReader.borrowedBooks.get(i).getId()) {
                currentReader.borrowedBooks.get(i).setRented(false);
                books.add(currentReader.borrowedBooks.get(i));
                currentReader.borrowedBooks.remove(i);

                System.out.println("Livro devolvido, obrigado :)");
                return;
            }
        }
        System.out.println("ID invalida, livro não encontrado");
    }

    public static void menu(ArrayList<Reader> readers, ArrayList<Book> books, int index ) {
        int input;
        Reader currentReader = readers.get(index);
        do {
            titulo(currentReader);
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Listar livros disponiveis");
            System.out.println("3. Ver meus livros");
            System.out.println("4. Devolver um livro");
            System.out.println("5. Voltar");
            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    showAll(books);
                    System.out.print("Digite a ID do livro que deseja adicionar: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine();
                    borrow(books, currentReader.getBorrowedBooks(), bookID);
                    break;
                case 2:
                    showAll(books);
                    break;

                case 3:
                    if (currentReader.getBorrowedBooks().isEmpty()) {
                        System.out.println("Nenhum livro emprestado!");
                        break;
                    }
                    else
                        myBooks(currentReader);
                    break;

                case 4:
                    if (!currentReader.getBorrowedBooks().isEmpty()) {
                        myBooks(currentReader);
                        System.out.print("Digite a ID do livro que deseja retornar: ");
                        bookID = scanner.nextInt();
                        scanner.nextLine();
                        returnBook(books, currentReader, bookID);
                        break;
                    }
                    else
                        System.out.println("Nenhum livro emprestado!");
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

    public static void titulo(Reader reader) {

        System.out.println("\t--- Bem vindo " + reader.getName() + "! ---");
        System.out.println();
    }
}
