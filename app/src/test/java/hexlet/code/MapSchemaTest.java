package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapSchemaTest {

    private static final Object ITEMS_NULL = null;
    private static final int MAP_SIZE = 3;

    private static final Map<String, Object> ITEMS_CORRECT = Map.of(
            "key1", "value1",
            "key2", MAP_SIZE,
            "key3", false
    );

    private static final Map<String, Object> ITEMS_INCORRECT = Map.of(
            "key1", "value1",
            "key2", false
    );

    @Test
    void testIsValid() {
        MapSchema schema1 = new Validator().map();

        assertTrue(schema1.isValid(ITEMS_NULL));
        assertTrue(schema1.isValid(ITEMS_CORRECT));
        assertFalse(schema1.isValid(MAP_SIZE));
    }

    @Test
    void testRequired() {
        MapSchema schema2 = new Validator().map().required();

        assertFalse(schema2.isValid(ITEMS_NULL));
        assertTrue(schema2.isValid(ITEMS_CORRECT));
    }

    @Test
    void testSizeof() {
        MapSchema schema3 = new Validator().map().sizeof(MAP_SIZE);

        assertTrue(schema3.isValid(ITEMS_NULL));
        assertTrue(schema3.isValid(ITEMS_CORRECT));
        assertFalse(schema3.isValid(ITEMS_INCORRECT));
    }

    @Test
    void testShape() {
        Map<String, BaseSchema> checksValid = Map.of(
                "key1", new Validator().string().required(),
                "key2", new Validator().number().positive()
        );

        MapSchema schema4 = new Validator().map().shape(checksValid);

        assertTrue(schema4.isValid(ITEMS_NULL));
        assertTrue(schema4.isValid(ITEMS_CORRECT));
        assertFalse(schema4.isValid(ITEMS_INCORRECT));

        Map<String, BaseSchema> checksInvalid = Map.of(
                "key1", new Validator().string().required(),
                "key3", new Validator().number()
        );

        MapSchema schema5 = new Validator().map().shape(checksInvalid);

        assertFalse(schema5.isValid(ITEMS_CORRECT));
    }
}
