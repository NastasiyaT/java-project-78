package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private List<Predicate<Object>> checks;

    public BaseSchema() {
        this.checks = new ArrayList<>();
    }

    public boolean isValid(Object item) {
        return checks.stream()
                .allMatch(i -> i.test(item));
    }

    public BaseSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }

    protected final void addCheck(Predicate<Object> condition) {
        checks.add(condition);
    }
}
