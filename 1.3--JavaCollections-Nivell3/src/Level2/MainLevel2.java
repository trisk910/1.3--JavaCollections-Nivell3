package Level2;

import Level2.Bussiness.Restaurant;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

public class MainLevel2 {
    public static void main(String[] args) {

        System.out.println("Exercici 1");
        HashSet<Restaurant> restaurants = new HashSet<>();

        int numRestaurants = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        do {

            try {
                System.out.print("Quants restaurants vols afegir? ");
                numRestaurants = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.err.println("Si us plau, introdueix un número vàlid.");
                scanner.next();
            }
        }while (!validInput);

        for(int i = 0; i < numRestaurants; i++) {
            System.out.print("Nom del restaurant " + (i + 1) + ": ");
            String name = scanner.next();
            System.out.print("Puntuació del restaurant " + (i + 1) + ": ");
            int score = scanner.nextInt();
            restaurants.add(new Restaurant(name, score));
        }

        for (Restaurant restaurant : restaurants) {
            System.out.println(restaurant);
        }

        System.out.println("----------------------Exercici 2----------------------");

        TreeSet<Restaurant> restTree = new TreeSet<>(restaurants);
        for (Restaurant restaurant : restTree) {
            System.out.println(restaurant);
        }
    }
}
