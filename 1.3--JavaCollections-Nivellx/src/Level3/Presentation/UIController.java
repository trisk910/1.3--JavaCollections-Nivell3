package Level3.Presentation;

import Level3.Bussiness.Person;
import Level3.Persistance.ExceptionEmptyList;
import Level3.Persistance.ExceptionMenuCatch;
import Level3.Persistance.PersonDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class UIController {

    private MainMenu mainMenu;
    private PersonDAO personDAO;
    //private static ArrayList<Person> persons = new ArrayList<>();
    private static final String emptyList = "No hi ha cap persona a la llista.";

    public UIController(MainMenu mainMenu, PersonDAO personDAO) {
        this.mainMenu = mainMenu;
        this.personDAO = personDAO;
    }
    public void start() throws ExceptionMenuCatch, ExceptionEmptyList {
        ArrayList<Person> persons;
        persons = (ArrayList<Person>) personDAO.getPersons();
        int menuOption = -1;
        do{
            try {
                int option = mainMenu.showMainMenu();
                switch (option) {
                    case 1:
                        addPerson(persons);
                        break;
                    case 2:
                        try{
                            showSortedPersonsByName(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opció no vàlida.\n");
                }
            }catch (ExceptionMenuCatch e){
                System.out.println(e.getMessage());
            }

        }while (menuOption != 0);

    }

    private void addPerson(ArrayList<Person> persons) {
        System.out.print("Introdueix el nom de la persona: ");
        String name = askForString();
        System.out.print("Introdueix el cognom de la persona: ");
        String surname = askForString();
        System.out.print("Introdueix el DNI de la persona: ");
        String DNI = askForString();
        Person person = new Person(name, surname, DNI);
        persons.add(person);
        personDAO.writePerson(person);
    }

    private void showSortedPersonsByName(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getName));
            sortedPersons.addAll(persons);
            for (Person person : sortedPersons) {
                System.out.println(person);
            }
            System.out.println();
        }
    }

    private String askForString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
