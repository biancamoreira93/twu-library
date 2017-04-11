package test;

import library.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bmoreira on 4/11/17.
 */
public class BookTest {

    Book book;

    @Before
    public void init(){
        book = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
    }

    @Test
    public void shouldCreateBookAndGetItsTitle(){
        String expectedTitle = "A Luz Atraves da Janela";

        assertEquals(book.getAuthorsName(), expectedTitle);
    }

    @Test
    public void shouldCheckoutABook(){

        assertEquals(true, book.checkoutBook());
    }

    @Test
    public void shouldCheckoutABookAndTryToCheckOutAgain(){
        book.checkoutBook();

        assertEquals(false, book.checkoutBook());
    }

    @Test
    public void shouldReturnABookSuccessfully(){
        book.checkoutBook();

        assertEquals(true, book.returnBook());
    }

    @Test
    public void shouldReturnABookUnsuccessfully(){

        assertEquals(false, book.returnBook());
    }

}