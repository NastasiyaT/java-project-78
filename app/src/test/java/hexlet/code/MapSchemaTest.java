package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    private static final int MAP_SIZE = 3;

    private MapSchema schema;

    @BeforeEach
    void getSchema() {
        schema = new Validator().map();
    }

    @ParameterizedTest
    @NullSource
    void testMapSchemaNullValue(Object obj) {
        assertTrue(schema.isValid(obj));
        assertFalse(schema.required().isValid(obj));
        assertFalse(schema.sizeof(MAP_SIZE).isValid(obj));
    }

    @Test
    void testMapSchema() {
        Map<String, Object> items1 = Map.of(
                "key1", "value1",
                "key2", MAP_SIZE,
                "key3", false
        );

        Map<String, Object> items2 = Map.of(
                "key1", "value1",
                "key3", false
        );

        assertTrue(schema.isValid(items1));
        assertTrue(schema.required().isValid(items1));
        assertTrue(schema.sizeof(MAP_SIZE).isValid(items1));
        assertFalse(schema.isValid("new value"));
        assertFalse(schema.sizeof(MAP_SIZE).isValid(items2));

        Map<String, BaseSchema> checks = Map.of(
                "key1", new Validator().string().required().contains("val"),
                "key2", new Validator().number().positive()
        );

        assertTrue(schema.shape(checks).isValid(items1));
        assertFalse(schema.shape(checks).isValid(items2));
    }
}
