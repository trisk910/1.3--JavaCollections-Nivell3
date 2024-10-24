package Level3.Presentation;

import Level3.Bussiness.Person;
import Level3.Persistance.ExceptionEmptyList;
import Level3.Persistance.PersonDAO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class UIController {

    private MainMenu mainMenu;
    private PersonDAO personDAO;
    private static final String emptyList = "No hi ha cap persona a la llista.";

    public UIController(MainMenu mainMenu, PersonDAO personDAO) {
        this.mainMenu = mainMenu;
        this.personDAO = personDAO;
    }
    public void start() {
        ArrayList<Person> persons;
        persons = (ArrayList<Person>) personDAO.getPersons();
        int menuOption = 0;
        do {
            try {
                menuOption = mainMenu.showMainMenu();
                switch (menuOption) {
                    case 1:
                        addPerson(persons);
                        break;
                    case 2:
                        showSortedPersonsByNameAZ(persons);
                        break;
                    case 3:
                        showSortedPersonsByNameZA(persons);
                        break;
                    case 4:
                        showSortedPersonsBySurnameAZ(persons);
                        break;
                    case 5:
                        showSortedPersonsBySurnameZA(persons);
                        break;
                    case 6:
                        showSortedPersonsByDNI1(persons);
                        break;
                    case 7:
                        showSortedPersonsByDNI2(persons);
                        break;
                    default:
                        System.err.println("Opció no vàlida.\n");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (menuOption != 0);
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

    private void showSortedPersonsByNameAZ(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getName));
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));
    }
    private void showSortedPersonsByNameZA(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getName).reversed());
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));
    }

    private void showSortedPersonsBySurnameAZ(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getSurname));
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));
    }
    private void showSortedPersonsBySurnameZA(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getSurname).reversed());
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));
    }
    private void showSortedPersonsByDNI1(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getDNI));
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));

    }
    private void showSortedPersonsByDNI2(ArrayList<Person> persons) throws ExceptionEmptyList {
        checkEmptyList(persons);
        TreeSet<Person> sortedPersons = new TreeSet<>(Comparator.comparing(Person::getDNI).reversed());
        sortedPersons.addAll(persons);
        printPersons(new ArrayList<>(sortedPersons));
    }
    private String askForString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private void checkEmptyList(ArrayList<Person> persons) throws ExceptionEmptyList {
        if (persons.isEmpty()) {
            throw new ExceptionEmptyList(emptyList);
        }
    }
    private void printPersons(ArrayList<Person> persons) {
        for (Person person : persons) {
            System.out.println(person);
        }
        System.out.println();
    }
}
