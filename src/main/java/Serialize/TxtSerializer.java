package Serialize;

import java.io.FileWriter;

public class TxtSerializer implements Serialize {
    @Override
    public void serialize(Object obj, String path) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(obj.toString());
            fileWriter.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public <T> T deserialize(Class<T> className, String path) {
        JsonSerializer jsonSerializer = new JsonSerializer();
        return jsonSerializer.deserialize(className, path);
    }
}
