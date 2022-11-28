package Serialize;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonSerializer implements Serialize {
    @Override
    public void serialize(Object obj, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), obj);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public <T> T deserialize(Class<T> className, String path) {
        T result = className.cast(null);
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.readValue(json, className);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
}


