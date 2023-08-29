package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 25;

    private static StringSchema schema;

    @BeforeEach
    void getSchema() {
        schema = new Validator().string();
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void testStringSchemaNullValue(String obj) {
        assertTrue(schema.isValid(obj));
        assertFalse(schema.minLength(MIN_VALUE).isValid(obj));
        assertFalse(schema.contains("nice").isValid(obj));
        assertFalse(schema.required().isValid(obj));
    }

    @Test
    void testStringSchema() {
        final String line = "Winter is coming!";

        assertTrue(schema.isValid(line));
        assertTrue(schema.required().contains(" is").minLength(MIN_VALUE).isValid(line));
        assertFalse(schema.minLength(MAX_VALUE).contains("no way").isValid(line));
        assertFalse(schema.minLength(MIN_VALUE).contains("no way").isValid(line));
        assertFalse(schema.minLength(MAX_VALUE).contains(" is").isValid(line));
        assertFalse(schema.required().contains(" is").minLength(MIN_VALUE).isValid(MAX_VALUE));
    }
}
