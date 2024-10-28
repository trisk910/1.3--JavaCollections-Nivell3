package Level1.Persistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class countriesDAO {
    public HashMap<String, String> readCountriesFromFile(String fileName) {
        HashMap<String, String> countriesMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
           do{
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    countriesMap.put(parts[0].trim(), parts[1].trim());
                }
            } while ((line = br.readLine()) != null);
        } catch (IOException e) {
            e.getMessage();
        }
        return countriesMap;
    }
}
