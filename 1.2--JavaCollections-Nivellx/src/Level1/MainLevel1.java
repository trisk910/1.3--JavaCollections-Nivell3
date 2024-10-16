package Level1;

import Level1.Bussiness.Month;
import Level1.Persistance.countriesDAO;
import Level1.Persistance.scoreListDAO;

import java.util.*;

public class MainLevel1 {
    public static void main(String[] args) {

        System.out.println("Exercici 1");
        ArrayList<Month> months = new ArrayList<>();

        months.add(new Month("Gener"));
        months.add(new Month("Febrer"));
        months.add(new Month("Març"));
        months.add(new Month("Abril"));
        months.add(new Month("Maig"));
        months.add(new Month("Juny"));
        months.add(new Month("Juliol"));
        months.add(new Month("Setembre"));
        months.add(new Month("Octubre"));
        months.add(new Month("Novembre"));
        months.add(new Month("Desembre"));

        months.add(7, new Month("Agost"));

        for (Month month : months) {
            System.out.println(month.getMonthName());
        }
        System.out.println("---------------------HashSet----------------------------");
        HashSet<Month> monthHS = new LinkedHashSet<>(months);

        for (Month month : monthHS) {
            System.out.println(month.getMonthName());
        }

        System.out.println("---------------------Iterator----------------------------");
        Iterator<Month> it = months.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getMonthName());
        }

        ///////////////////////////////////////////////////////////////////////////////////
        System.out.println("\nExercici 2");

        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        List<Integer> secondList = new ArrayList<>();

        ListIterator<Integer> iterator = firstList.listIterator(firstList.size());
        while (iterator.hasPrevious()) {
            secondList.add(iterator.previous());
        }

        for (Integer n : secondList) {
            System.out.println(n);
        }

        ///////////////////////////////////////////////////////////////////////////////////
        System.out.println("\nExercici 3");

        countriesDAO countries = new countriesDAO();
        HashMap<String, String> countriesMap = countries.readCountriesFromFile("countries.txt");
        scoreListDAO scoreList = new scoreListDAO();

        /*for (Map.Entry<String, String> entry : countriesMap.entrySet()) {
            System.out.println("Pais: " + entry.getKey() + " Capital: " + entry.getValue());
        }*/

        System.out.println("Introdueix el teu nom: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        int score = 0;
        List<String> countriesList = new ArrayList<>(countriesMap.keySet());
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String randomCountry = countriesList.get(random.nextInt(countriesList.size()));
            System.out.println("Quina és la capital de " + randomCountry + "?");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(countriesMap.get(randomCountry))) {
                score++;
                System.out.println("Correcte!");
            } else {
                System.out.println("Incorrecte!");
            }
        }
        System.out.println("Puntuació final: " + score);
        HashMap<String, Integer> Player = new HashMap<>();
        Player.put(name, score);

        scoreList.saveScore(Player);
    }
}