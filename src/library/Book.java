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

    public String checkoutBook(){
        if (this.bookCheckedOut){
            return "That book is not available.\n";
        }

        this.bookCheckedOut = true;
        return "Thank you! Enjoy the book.\n";
    }

    public String returnBook(){
        if (this.bookCheckedOut){

            this.bookCheckedOut = false;
            return "Thank you for returning the book.\n";
        }

        return "That's not a valid book to return.\n";
    }

    public boolean getBookCheckedOut(){
        return this.bookCheckedOut;
    }

    public String getBookDetails() {
        String bookDetails = "Title: " + this.getTitle() + "\n";
        bookDetails += "Author: " + this.getAuthorsName() + "\n";
        bookDetails += "Year: " + this.getYearPublished() + "\n\n";

        return bookDetails;
    }
}
