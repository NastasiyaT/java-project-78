package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
        addCheck(item -> Objects.isNull(item) || item instanceof Map<?, ?>);
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int quantity) {
        addCheck(item -> Objects.isNull(item) || ((Map<?, ?>) item).size() == quantity);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(mapItem -> Objects.isNull(mapItem)
                || schemas.entrySet().stream().allMatch(check -> {
                    Object value = ((Map<?, ?>) mapItem).get(check.getKey());
                    return check.getValue().isValid(value);
                }));
        return this;
    }
}
