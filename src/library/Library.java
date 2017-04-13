package library;

import java.util.ArrayList;

/**
 * Created by bmoreira on 4/11/17.
 */
public class Library {

    private ArrayList<Book> booksList = new ArrayList<Book>();
    private static Library library = new Library();

    public static Library getInstance(){
        return library;
    }

    public ArrayList<Book> getBooksList(){
        return booksList;
    }

    public void addBook(Book book) {
        booksList.add(book);
    }

    public String showBooksListAndInfo() {
        String booksListReturn = "";
        int booksIndex = 0;

        if (!isBookListEmpty()) {
            for (Book book : booksList) {
                if (!book.getBookCheckedOut()) {
                    booksListReturn += "Book's index: " + booksIndex + "\n" + book.getBookDetails();
                }
                booksIndex++;
            }
            return booksListReturn;
        }

        return "Library is empty!";
    }


    public boolean isBookListEmpty() {
        if (booksList.size()>0){
            return false;
        }
        return true;
    }

    public String returnBook(int bookIndex) {
        return booksList.get(bookIndex).returnBook();
    }

    public String checkoutBook(int bookIndex) {
        return booksList.get(bookIndex).checkoutBook();
    }
}
