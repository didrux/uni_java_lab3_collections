package Serialize;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlSerializer implements Serialize {
    @Override
    public void serialize(Object obj, String path) {
        XmlMapper mapper = new XmlMapper();
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
            String xml = new String(Files.readAllBytes(Paths.get(path)));
            XmlMapper mapper = new XmlMapper();
            result = mapper.readValue(xml, className);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
}
