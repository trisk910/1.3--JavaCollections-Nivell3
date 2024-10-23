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
                            showSortedPersonsByNameAZ(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        try{
                            showSortedPersonsByNameZA(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        try{
                            showSortedPersonsBySurnameAZ(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            showSortedPersonsBySurnameZA(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        try {
                            showSortedPersonsByDNI1(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 7:
                        try {
                            showSortedPersonsByDNI2(persons);
                        }catch (ExceptionEmptyList e){
                            System.out.println(e.getMessage());
                        }
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
        System.out.print("Introdueix els cognoms de la persona[c1 c2]: ");
        String surname = askForString();
        System.out.print("Introdueix el DNI de la persona: ");
        String DNI = askForString();
        Person person = new Person(name, surname, DNI);
        persons.add(person);
        personDAO.writePerson(person);
    }

    private void showSortedPersonsByNameAZ(ArrayList<Person> persons) {
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
    private void showSortedPersonsByNameZA(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getName).reversed());
            sortedPersons.addAll(persons);
            for (Person person : sortedPersons) {
                System.out.println(person);
            }
            System.out.println();
        }
    }

    private void showSortedPersonsBySurnameAZ(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getSurname));
            sortedPersons.addAll(persons);
            for (Person person : sortedPersons) {
                System.out.println(person);
            }
            System.out.println();
        }
    }
    private void showSortedPersonsBySurnameZA(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getSurname).reversed());
            sortedPersons.addAll(persons);
            for (Person person : sortedPersons) {
                System.out.println(person);
            }
            System.out.println();
        }
    }

    private void showSortedPersonsByDNI1(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getDNI));
            sortedPersons.addAll(persons);
            for (Person person : sortedPersons) {
                System.out.println(person);
            }
            System.out.println();
        }
    }
    private void showSortedPersonsByDNI2(ArrayList<Person> persons) {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        } else {
            TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getDNI).reversed());
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
