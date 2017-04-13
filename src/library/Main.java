package library;

import java.util.Scanner;

/**
 * Created by bmoreira on 4/13/17.
 */
public class Main {
    public static void main(String args[]){
        Menu menu = new Menu();

        Scanner scanner = new Scanner(System.in);
        System.out.println(menu.welcomeMessage());
        menu.setInput(scanner);

        if (menu.showMenu()){
            System.exit(0);
        }
    }
}
