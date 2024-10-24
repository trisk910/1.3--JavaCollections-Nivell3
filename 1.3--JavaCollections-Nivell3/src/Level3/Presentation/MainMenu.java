package Level3.Presentation;

import java.util.Scanner;

public class MainMenu {

    public int showMainMenu(){
        Scanner scanner = new Scanner(System.in);
        int menuOption = 0;
        boolean validInput = false;

       do{
            System.out.println("1.- Introduir persona.");
            System.out.println("2.- Mostrar les persones ordenades per nom (A-Z).");
            System.out.println("3.- Mostrar les persones ordenades per nom (Z-A).");
            System.out.println("4.- Mostrar les persones ordenades per cognoms (A-Z).");
            System.out.println("5.- Mostrar les persones ordenades per cognoms (Z-A).");
            System.out.println("6.- Mostrar les persones ordenades per DNI (1-9).");
            System.out.println("7.- Mostrar les persones ordenades per DNI (9-1).");
            System.out.println("0.- Sortir.");

            System.out.print("Opcio: ");
            String input = scanner.nextLine();
            try {
                menuOption = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Opció no disponible.\n");
            }
        }while (!validInput);
        System.out.println();
        return menuOption;
    }
}
