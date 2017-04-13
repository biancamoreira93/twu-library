package test;

import library.Book;
import library.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bmoreira on 4/11/17.
 */
public class LibraryTest {


    @Test
    public void shouldAddABookToLibrary(){
        Library library = Library.getInstance();
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        library.addBook(book);

        assertEquals(book.getTitle(), library.getBooksList().get(0).getTitle());
    }

    @Test
    public void shouldReturnAllBooksDetails(){
        Library library = Library.getInstance();
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        library.addBook(book);
        Book expectedBook = library.getBooksList().get(0);

        assertEquals(expectedBook, book);
    }

    @Test
    public void shouldReturnTrueWhenBooksListIsEmpty(){
        Library library = Library.getInstance();

        assertEquals(true, library.isBookListEmpty());

    }

    @Test
    public void shouldShowReturningMessageWhenBookIsReturned(){
        Library library = Library.getInstance();
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        library.addBook(book);
        library.checkoutBook(0);

        String expectedReturn = "Thank you for returning the book.\n";

        assertEquals(expectedReturn, library.returnBook(0));
    }

    @Test
    public void shouldShowNotValidMessageWhenBookIsReturned(){
        Library library = Library.getInstance();
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        library.addBook(book);

        String expectedReturn = "That's not a valid book to return.\n";

        assertEquals(expectedReturn, library.returnBook(0));
    }

}