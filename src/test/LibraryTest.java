package test;

import library.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bmoreira on 4/11/17.
 */
public class LibraryTest {

    Library library;

    @Before
    public void init(){
        library = new Library();
    }

    @Test
    public void shouldPrintWelcomeMessage(){
        String expectedReturn = "Hello! Welcome to the Online Library!";

        assertEquals(expectedReturn, library.welcomeMessage());
    }

    @Test
    public void shouldShowLibraryMenuAndThenQuit(){
        library.setMenuOption(9);

        assertEquals(true, library.libraryMenu());
    }

    @Test
    public void shouldShowLibraryMenuAndGetListBooks(){
        library.setMenuOption(0);

        assertEquals(true, library.libraryMenu());
    }

    @Test
    public void shouldSetABookFromBookListChecked(){
        library.getBooksList().get(1).checkoutBook();
        library.setMenuOption(0);

        assertEquals(true, library.libraryMenu());
    }

    @Test
    public void shouldShowLibraryMenuAndGetInvalidOption(){
        library.setMenuOption(1);

        assertEquals(true, library.libraryMenu());
    }


}