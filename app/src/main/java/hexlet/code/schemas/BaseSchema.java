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

    /**
     * Applies all check conditions to the object.
     * @param item object to validate
     * @return result if the object meets conditions in the schema or not
     */
    public boolean isValid(Object item) {
        return checks.stream()
                .allMatch(i -> i.test(item));
    }

    /**
     * Updates current schema.
     * Adds new basic condition to check if the object isn't null.
     * @return renewed schema
     */
    public BaseSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }

    protected final void addCheck(Predicate<Object> condition) {
        checks.add(condition);
    }
}
