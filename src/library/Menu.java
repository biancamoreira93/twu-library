package library;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by bmoreira on 4/13/17.
 */
public class Menu {
    private int menuOption;
    private Library library = Library.getInstance();
    private Scanner keyboard;

    public void setMenuOption() {
        this.menuOption = menuOption;
    }

    public void setInput(Scanner keyboard){
        this.keyboard = keyboard;
    }

    public String welcomeMessage() {
        return "Hello! Welcome to the Online Library!";
    }

    public String getMenuItems(){
        String menuOptions = "Menu " +
                "\n-----------------------\n";
        menuOptions += "0 - List books\n";
        menuOptions += "1 - Check out book\n";
        menuOptions += "2 - Return book\n";
        menuOptions += "9 - Quit\n";

        return menuOptions;
    }

    public String choseALibraryMenuOption(int chosenOption) throws Exception{
        switch (chosenOption){
            case 0:
                return library.showBooksListAndInfo();
            case 1:
                return this.returnBookOption();
            case 9:
                return "Quitting...";
            default:
                return "Select a valid option!";

        }
    }

    public boolean showMenu(){

        do {
            this.menuOption = Integer.valueOf(keyboard.nextLine());
            try {

                System.out.println(getMenuItems());
                System.out.println(choseALibraryMenuOption(this.menuOption));

            } catch (Exception e) {
                /*todo treat exception*/
                e.printStackTrace();
            }

        }while (keyboard.hasNext()  && this.menuOption!=9);

        return true;
    }

    public String returnBookOption() {
        System.out.println("Write the book's index you want to return:\n");
        int bookIndex = Integer.valueOf(keyboard.nextLine());

        return library.returnBook(bookIndex);
    }

    public String checkoutBookOption() {
        System.out.println("Write the book's index you want to checkout:\n");
        int bookIndex = Integer.valueOf(keyboard.nextLine());

        return library.checkoutBook(bookIndex);
    }
}
