package hexlet.code.schemas;

import java.util.Objects;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        addCheck(item -> item instanceof String || Objects.isNull(item));
    }

    @Override
    public StringSchema required() {
        super.required();
        addCheck(item -> !item.equals(""));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(item -> Objects.nonNull(item) && ((String) item).length() >= length);
        return this;
    }

    public StringSchema contains(String phrase) {
        addCheck(item -> Objects.nonNull(item) && ((String) item).contains(phrase));
        return this;
    }
}
