package Level3.Persistance;

import Level3.Bussiness.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static final String fileName = "persons.csv";

    public PersonDAO() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void writePerson(Person person) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            writer.println(person.getName() + " " + person.getSurname() + " " + person.getDNI());
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = reader.readLine()) != null; ) {
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    String surname = parts[1] + " " + parts[2];
                    persons.add(new Person(parts[0], surname, parts[3]));
                } else {
                    System.out.println("ERROR: Format de persona incorrecte");
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return persons;
    }
}
