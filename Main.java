import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        ArrayList<book> library = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 6){
            System.out.println("What would You like to do: \nOption 1: Add a book \nOption 2: Show all books\nOption 3: Search for a book\nOption 4: Borrow a book\nOption 5: Return a book\nOption 6: Exit");
            option = readInt(scanner);
            int search; 
            String outputBuffer;
            ArrayList<book> candidatebuffer = new ArrayList<>(); 
            switch (option) {
                case 1: //add a book
                    System.out.println("Please enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.println("Please enter the year of the book: ");
                    int year = readInt(scanner);
                    System.out.println("Please enter the author of the book: ");
                    String author = scanner.nextLine();
                    book newbook = new book(title, author, year);
                    library.add(newbook);
                    System.out.println("There is now "+library.size()+" books in the library.\nOperation successful. ");
                    break;
                case 2: //show all books
                    for (book currentBook : library) {
                        System.out.println("Title: "+ currentBook.getTitle() + "\nAuthor: "+currentBook.getAuthor()+"\nYear: "+currentBook.getYear()+"\nBorrowed:" + currentBook.getStringBorrowed());
                    }
                    break;
                case 3: //search by author or by name and list
                    System.out.println("Search by author [1], or by bookname [2]? ");
                    search = readInt(scanner);
                    outputBuffer = ""; 
                    switch (search){
                        case 1:
                            System.out.println("Author name?");
                            String searchAuthor = scanner.nextLine();
                            for (book currentBook : library){
                                if (!currentBook.getIfFoundByAuthor(searchAuthor).isEmpty()){
                                    outputBuffer += currentBook.getIfFoundByAuthor(searchAuthor) +"\n";
                                }
                            }
                            if (outputBuffer.isEmpty()){
                                System.out.println("No book in the library matched your input author. ");
                            }else{
                                System.out.println("The following books have been found: \n" +outputBuffer);
                            }
                            break;
                        case 2:
                            System.out.println("Book name?");
                            String searchBook = scanner.nextLine();
                            for (book currentBook : library){
                                if (!currentBook.getIfFoundByName(searchBook).isEmpty()){
                                    outputBuffer += currentBook.getIfFoundByName(searchBook) +"\n";
                                }
                            }
                            if (outputBuffer.isEmpty()){
                                System.out.println("No book in the library matched your input book name. ");
                            }else{
                                System.out.println("The following books have been found: \n" +outputBuffer);
                            }
                            break;
                        default:
                            System.out.println("Incorrect option chosen");
                    }
                    break;
                    
                case 4: //borrow a book, search first
                    System.out.println("Search by author [1], or by bookname [2]? ");
                    search = readInt(scanner);
                    
                    switch (search){
                        case 1:
                            System.out.println("Author name?");
                            String searchAuthor = scanner.nextLine();
                            for (book currentBook : library){
                                if (currentBook.getIfFoundByAuthor(searchAuthor).isEmpty()){
                                    continue;
                                }else{
                                    candidatebuffer.add(currentBook);
                                }
                            }
                            if (candidatebuffer.isEmpty()){
                                System.out.println("Didn't find it. ");
                            }else if(candidatebuffer.size()==1){
                                System.out.println("The following books have been found and borrowed: \n" +candidatebuffer.get(0).getTitle());
                                candidatebuffer.get(0).changeBookBorrowed(true);
                            }else{
                                System.out.println("Multiple book results have been found, please try to be more precise");
                                for (book b : candidatebuffer) {System.out.println(b.getTitle());}
                            }
                            break;
                        case 2:
                            System.out.println("Book name?");
                            String searchBook = scanner.nextLine();
                            for (book currentBook : library){
                                if (currentBook.getIfFoundByName(searchBook).isEmpty()){
                                    continue;
                                }else{
                                    candidatebuffer.add(currentBook);
                                }
                            }
                            if (candidatebuffer.isEmpty()){
                                System.out.println("Didn't find it. ");
                            }else if(candidatebuffer.size() == 1){
                                System.out.println("The following books have been found and borrowed: \n" +candidatebuffer.get(0).getTitle());
                                candidatebuffer.get(0).changeBookBorrowed(true);
                            }else{
                                System.out.println("Multiple book results have been found, please try to be more precise");
                                for (book b : candidatebuffer) {System.out.println(b.getTitle());}
                            }
                            break;
                        default:
                            System.out.println("Incorrect option chosen");
                    }
                    break;
                case 5: //return a book
                    System.out.println("Search by author [1], or by bookname [2]? ");
                    search = readInt(scanner);
                    switch (search){
                        case 1:
                            System.out.println("Author name?");
                            String searchAuthor = scanner.nextLine();
                            for (book currentBook : library){
                                if (currentBook.getIfFoundByAuthor(searchAuthor).isEmpty()){
                                    continue;
                                }else{
                                    candidatebuffer.add(currentBook);
                                }
                            }
                            if (candidatebuffer.isEmpty()){
                                System.out.println("Didn't find it. ");
                            }else if(candidatebuffer.size()==1){
                                System.out.println("The following books have been found and returned: \n" +candidatebuffer.get(0).getTitle());
                                candidatebuffer.get(0).changeBookBorrowed(false);
                            }else{
                                System.out.println("Multiple book results have been found, please try to be more precise");
                                for (book b : candidatebuffer) {System.out.println(b.getTitle());}
                            }
                            break;
                        case 2:
                            System.out.println("Book name?");
                            String searchBook = scanner.nextLine();
                            for (book currentBook : library){
                                if (currentBook.getIfFoundByName(searchBook).isEmpty()){
                                    continue;
                                }else{
                                    candidatebuffer.add(currentBook);
                                }
                            }
                            if (candidatebuffer.isEmpty()){
                                System.out.println("Didn't find it. ");
                            }else if(candidatebuffer.size() == 1){
                                System.out.println("The following books have been found and returned: \n" +candidatebuffer.get(0).getTitle());
                                candidatebuffer.get(0).changeBookBorrowed(false);
                            }else{
                                System.out.println("Multiple book results have been found, please try to be more precise");
                                for (book b : candidatebuffer) {System.out.println(b.getTitle());}
                            }
                            break;
                        default:
                            System.out.println("Incorrect option chosen");
                    }
                    break;
                case 6: //exit
                    scanner.close();
                    break;
                default:
                    System.out.println("This is not an option. ");
                    break;
            }
        }
    }
    static int readInt(Scanner scanner) { //so that the nextInt dont crash 
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
