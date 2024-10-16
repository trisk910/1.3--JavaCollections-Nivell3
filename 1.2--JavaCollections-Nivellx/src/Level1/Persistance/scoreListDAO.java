package Level1.Persistance;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class scoreListDAO {

    public void saveScore(HashMap<String, Integer> player) {
        try (FileWriter writer = new FileWriter("classificacio.txt", true)) {
            for (String name : player.keySet()) {
                writer.write(name + player.get(name) + " punts\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
