package library;

import java.util.ArrayList;

/**
 * Created by bmoreira on 4/11/17.
 */
public class Library {

    private ArrayList<Book> booksList = new ArrayList<Book>();
    private int menuOption;

    public Library(){
        booksList.add(new Book("A Luz Atraves da Janela", "Lucinda Riley", 2009));
        booksList.add(new Book("Harry Potter Box", "JK Rowling", 2001));
        booksList.add(new Book("Game of Thrones", "G R Martin", 2005));
    }

    public ArrayList<Book> getBooksList(){
        return booksList;
    }

    public void setMenuOption(int menuOption) {
        this.menuOption = menuOption;
    }

    public String welcomeMessage() {
        return "Hello! Welcome to the Online Library!";
    }


    private String showBooksListAndInfo() {
        String booksListReturn = "";
        for (int i=0; i<booksList.size(); i++){
            if (!booksList.get(i).getBookCheckedOut()){
                booksListReturn += "Title: " + booksList.get(i).getTitle() + "\n";
                booksListReturn += "Author: " + booksList.get(i).getAuthorsName() + "\n";
                booksListReturn += "Year: " + booksList.get(i).getYearPublished() + "\n\n";
            }
        }
        return booksListReturn;
    }

    public boolean libraryMenu(){

        System.out.println(showLibraryMenuItems());
        System.out.println(choseALibraryMenuOption(menuOption));

        return true;
    }

    private String showLibraryMenuItems(){
        String menuOptions = "Menu \n-----------------------\n";
        menuOptions += "0 - List Books\n";
        menuOptions += "9 - Quit\n";

        return menuOptions;
    }

    private String choseALibraryMenuOption(int chosenOption) {
        String chosenReturn;

        if (chosenOption==0){
            chosenReturn = showBooksListAndInfo();
        }else{
            chosenReturn = "Select a valid option!";
        }

        return chosenReturn;
    }
}
