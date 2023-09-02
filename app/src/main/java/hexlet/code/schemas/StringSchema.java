package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class StringSchema extends BaseSchema {

    public StringSchema() {
        super();
        addCheck(item -> Objects.isNull(item) || item instanceof String || StringUtils.isEmpty(item.toString()));
    }

    @Override
    public StringSchema required() {
        super.required();
        addCheck(item -> !StringUtils.isEmpty((String) item));
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(item -> Objects.isNull(item) || item.equals("") || ((String) item).length() >= length);
        return this;
    }

    public StringSchema contains(String phrase) {
        addCheck(item -> Objects.isNull(item) || item.equals("") || ((String) item).contains(phrase));
        return this;
    }
}
