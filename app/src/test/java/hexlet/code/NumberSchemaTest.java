package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    private static final int MIN_VALUE = 2;
    private static final int MAX_VALUE = 90;

    private NumberSchema schema;

    @BeforeEach
    void getSchema() {
        schema = new Validator().number();
    }

    @ParameterizedTest
    @NullSource
    void testNumberSchemaNullValue(Object obj) {
        assertTrue(schema.isValid(obj));
        assertFalse(schema.required().isValid(obj));
        assertFalse(schema.positive().isValid(obj));
        assertFalse(schema.range(MIN_VALUE, MAX_VALUE).isValid(obj));
    }

    @Test
    void testNumberSchema() {
        final int item1 = 31;
        final int item2 = 109;
        final int item3 = 0;
        final int item4 = -6;

        assertTrue(schema.isValid(item1));
        assertTrue(schema.isValid(item3));
        assertTrue(schema.isValid(item4));
        assertFalse(schema.isValid("nice"));

        assertTrue(schema.required().isValid(item1));
        assertTrue(schema.required().isValid(item3));
        assertTrue(schema.required().isValid(item4));

        assertTrue(schema.required().positive().isValid(item1));
        assertFalse(schema.required().positive().isValid(item3));
        assertFalse(schema.required().positive().isValid(item4));

        assertTrue(schema.required().range(MIN_VALUE, MAX_VALUE).isValid(item1));
        assertFalse(schema.required().range(MIN_VALUE, MAX_VALUE).isValid(item2));
        assertFalse(schema.required().range(MIN_VALUE, MAX_VALUE).isValid(item4));
    }
}
