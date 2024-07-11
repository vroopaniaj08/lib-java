import java.util.ArrayList;
import java.util.Scanner;

interface lib {
    boolean login();
}

interface book_record {
    boolean addBook();
    void showBook();
    // void submitBook();
}

class Login implements lib {
    private String email;
    private String password;

    Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean login() {
        String[][] cre = {
            {"apoorvjain7222@gmail.com", "apoorvjain08"},
            {"babu@gmail.com", "babu08"},
            {"dev@gmail.com", "dev08"}
        };

        for (String[] credentials : cre) {
            if (email.equals(credentials[0]) && password.equals(credentials[1])) {
                return true;
            }
        }
        return false;
    }
}

class AddBook implements book_record {
    private static ArrayList<String> books = new ArrayList<>();
    private String book_name;
    public AddBook(){

    }
    public AddBook(String book_name) {
        this.book_name = book_name;
    }

    @Override
    public boolean addBook() {
        return books.add(book_name);
    }

    @Override
    public void showBook() {
        for(int i=0;i<books.size();i++){
            System.out.println(books.get(i));
        }
    }
}

public class LibraryManagementSystem {
    private static boolean loginStatus;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email:");
        String email = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        Login loginObj = new Login(email, password);
        loginStatus = loginObj.login();
        
        if (!loginStatus) {
            System.out.println("Login failed!");
            sc.close();
            return;
        }
        
        System.out.println("Login successful!");
        AddBook bookObj1 = new AddBook();
        
        while(true){
            System.out.println("\npress 1 to add a book");
            System.out.println("press 2 to show all the books");
            System.out.println("press 3 to exit");
            int number = sc.nextInt();
            sc.nextLine(); // Consume the newline
            
            switch(number) {
                case 1:
                System.out.println("Enter a book name to add:");
                String bookName = sc.nextLine();
                AddBook bookObj = new AddBook(bookName);
                    boolean addedBook = bookObj.addBook();
                    System.out.println("Book added successfully: " + addedBook);
                    break;
                case 2:
                    System.out.println("All books:");
                    bookObj1.showBook();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    public static boolean getLoginStatus() {
        return loginStatus;
    }
}