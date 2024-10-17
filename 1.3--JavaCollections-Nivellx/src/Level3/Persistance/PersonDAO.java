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
                e.printStackTrace();
            }
        }
    }

    public void writePerson(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(person.getName() + " " + person.getSurname() + " " + person.getDNI());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String surname = parts[1] + " " + parts[2];
                persons.add(new Person(parts[0], surname, parts[3]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
}
