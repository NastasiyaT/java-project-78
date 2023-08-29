package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        super();
        addCheck(item -> item instanceof Integer || Objects.isNull(item));
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        addCheck(item -> Objects.nonNull(item) && (Integer) item > 0);
        return this;
    }

    public NumberSchema range(int from, int to) {
        addCheck(item -> Objects.nonNull(item) && (Integer) item >= from && (Integer) item <= to);
        return this;
    }
}
