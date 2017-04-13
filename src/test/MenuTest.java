package test;

import library.Book;
import library.Library;
import library.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by bmoreira on 4/13/17.
 */
public class MenuTest {

    Menu menu;
    Library library;
    Book book1;
    Book book2;

    @Before
    public void init(){
        menu = new Menu();
        book1 = new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009);
        book2 = new Book("Harry Potter Box", "J K Rowling", 2001);

        library = Library.getInstance();
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        Menu menu = new Menu();
        String expectedReturn = "Hello! Welcome to the Online Library!";

        assertEquals(expectedReturn, menu.welcomeMessage());
    }

    @Test
    public void shouldReturnMenuList(){
        Menu menu = new Menu();
        String expectedMenuOptions = "Menu " +
                "\n-----------------------\n";
        expectedMenuOptions += "0 - List books\n";
        expectedMenuOptions += "1 - Check out book\n";
        expectedMenuOptions += "2 - Return book\n";
        expectedMenuOptions += "9 - Quit\n";

        assertEquals(expectedMenuOptions, menu.getMenuItems());

    }

    @Test
    public void shouldShowMenuAndThenQuit() throws Exception {
        Menu menu = new Menu();
        String expectedReturn = "Quitting...";

        assertEquals(expectedReturn, menu.choseALibraryMenuOption(9));
    }


    @Test
    public void shouldChooseMenuOptionAndGetInvalidOption() throws Exception {
        Menu menu = new Menu();
        String expectedReturn = "Select a valid option!";

        assertEquals(expectedReturn, menu.choseALibraryMenuOption(10));
    }

    @Test
    public void shouldShowMenuOptionZero(){

        Scanner keyboard = new Scanner("0");
        menu.setInput(keyboard);

        assertEquals(true, menu.showMenu());
    }

    @Test
    public void shouldShowMenuOptionNine(){

        Scanner keyboard = new Scanner("9");
        menu.setInput(keyboard);

        assertEquals(true, menu.showMenu());
    }

    @Test
    public void shouldShowMenuOptionZeroAndNine(){

        Scanner keyboard = new Scanner("0\n9");
        menu.setInput(keyboard);

        assertEquals(true, menu.showMenu());
    }

    @Test
    public void shouldShowMenuOptionZeroAndNineWithoutBooks(){
        Scanner keyboard = new Scanner("0\n9");
        menu.setInput(keyboard);

        assertEquals(true, menu.showMenu());
    }

    @Test
    public void shouldReturnReturnedMessageWhenReturningABook(){

        library.checkoutBook(0);

        Scanner keyboard = new Scanner("0");
        menu.setInput(keyboard);

        String expectedMessage = "Thank you for returning the book.\n";

        assertEquals(expectedMessage, menu.returnBookOption());
    }

    @Test
    public void shouldReturnEnjoyMessageWhenCheckingOutABook(){

        Scanner keyboard = new Scanner("0");
        menu.setInput(keyboard);

        String expectedMessage = "Thank you! Enjoy the book.\n";

        assertEquals(expectedMessage, menu.checkoutBookOption());
    }

    @Test
    public void shouldReturnNotAvailableMessageWhenCheckingOutABook(){

        library.checkoutBook(0);

        Scanner keyboard = new Scanner("0");
        menu.setInput(keyboard);

        String expectedMessage = "That book is not available.\n";

        assertEquals(expectedMessage, menu.checkoutBookOption());
    }
}