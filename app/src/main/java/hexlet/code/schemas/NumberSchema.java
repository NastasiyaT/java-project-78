package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
        addCheck(item -> Objects.isNull(item) || item instanceof Integer);
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        addCheck(item -> Objects.isNull(item) || (Integer) item > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        addCheck(item -> Objects.isNull(item) || (Integer) item >= from && (Integer) item <= to);
        return this;
    }
}
