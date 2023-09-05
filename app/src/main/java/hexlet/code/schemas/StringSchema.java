package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        addCheck(item -> Objects.isNull(item) || item instanceof String);
    }

    @Override
    public StringSchema required() {
        addCheck(item -> !StringUtils.isEmpty((String) item));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(item -> Objects.isNull(item) || ((String) item).length() >= length);
        return this;
    }

    public StringSchema contains(String phrase) {
        addCheck(item -> Objects.isNull(item) || ((String) item).contains(phrase));
        return this;
    }
}
