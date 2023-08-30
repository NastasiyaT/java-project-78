package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        super();
        addCheck(item -> item instanceof Map<?, ?> || Objects.isNull(item));
    }

    @Override
    public MapSchema required() {
        super.required();
        addCheck(item -> Objects.nonNull(item) && item instanceof Map<?, ?>);
        return this;
    }

    public MapSchema sizeof(int quantity) {
        addCheck(item -> Objects.nonNull(item) && ((Map<?, ?>) item).size() == quantity);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(mapItem -> Objects.nonNull(mapItem) &&
                schemas.entrySet().stream().allMatch(check -> {
                            Object value = ((Map<?, ?>)mapItem).get(check.getKey());
                            return check.getValue().isValid(value);
                        }));
        return this;
    }
}
