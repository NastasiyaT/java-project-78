package hexlet.code.schemas;

public interface Schema {
    boolean isValid(Object obj);
    Schema required();
}