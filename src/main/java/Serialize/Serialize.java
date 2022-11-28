package Serialize;

public interface Serialize {
    void serialize(Object obj, String path);

    <T> T deserialize(Class<T> className, String path);
}
