package lab4.json;
import com.google.gson.Gson;
import lab4.model.University;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private Gson gson;

    public JsonManager() {
        gson = new Gson();
    }

    public void writeToJson(University university, String fileName) {
        String json = gson.toJson(university);
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public University readFromJson(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
