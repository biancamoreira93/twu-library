package library;

/**
 * Created by bmoreira on 4/11/17.
 */
public class Book {
    private String title;
    private String authorsName;
    private int yearPublished;
    private boolean bookCheckedOut;

    public Book(String title, String authorsName, int yearPublished){
        this.title = title;
        this.authorsName = authorsName;
        this.yearPublished = yearPublished;
        this.bookCheckedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorsName() {
        return authorsName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public boolean checkoutBook(){
        if (this.bookCheckedOut){
            System.out.println("That book is not available.\n");
            return false;
        }else{
            System.out.println("Book: " + this.title + " checked out!\n");
            System.out.println("Thank you! Enjoy the book.\n");
            this.bookCheckedOut = true;
            return true;
        }
    }

    public boolean returnBook(){
        if (this.bookCheckedOut){
            System.out.println("Thank you for returning the book.\n");
            this.bookCheckedOut = false;
            return true;
        }else{
            System.out.println("That's not a valid book to return.\n");
            return false;
        }
    }


    public boolean getBookCheckedOut() {
        return bookCheckedOut;
    }
}
