package test;

import library.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bmoreira on 4/11/17.
 */
public class BookTest {


    @Test
    public void shouldCreateBookAndGetItsTitle(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        String expectedTitle = "A Luz Atraves da Janela";

        assertEquals(book.getAuthorsName(), expectedTitle);
    }

    @Test
    public void shouldCheckoutABook(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        assertEquals(true, book.checkoutBook());
    }

    @Test
    public void shouldCheckoutABookAndTryToCheckOutAgain(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        book.checkoutBook();

        assertEquals(false, book.checkoutBook());
    }

    @Test
    public void shouldReturnABookSuccessfully(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        book.checkoutBook();

        assertEquals(true, book.returnBook());
    }

    @Test
    public void shouldReturnABookUnsuccessfully(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        assertEquals(false, book.returnBook());
    }

    @Test
    public void shouldReturnBookDetails(){
        Book book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);

        String expectedReturn = "Title: " + book.getTitle() + "\n";
        expectedReturn += "Author: " + book.getAuthorsName() + "\n";
        expectedReturn += "Year: " + book.getYearPublished() + "\n\n";

        assertEquals(expectedReturn, book.getBookDetails());
    }

}