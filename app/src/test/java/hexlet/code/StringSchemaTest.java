package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    private static final Object LINE_NULL = null;
    private static final String LINE_EMPTY = "";
    private static final String LINE = "Winter is coming!";
    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 25;
    private static final String LINE_TRUE = " is";
    private static final String LINE_FALSE = "no way";

    @Test
    void testIsValid() {
        StringSchema schema1 = new Validator().string();

        assertTrue(schema1.isValid(LINE));
        assertTrue(schema1.isValid(LINE_NULL));
        assertTrue(schema1.isValid(LINE_EMPTY));
        assertFalse(schema1.isValid(MIN_VALUE));
    }

    @Test
    void testRequired() {
        StringSchema schema2 = new Validator().string().required();

        assertTrue(schema2.isValid(LINE));
        assertFalse(schema2.isValid(LINE_NULL));
        assertFalse(schema2.isValid(LINE_EMPTY));
    }

    @Test
    void testMinLength() {
        StringSchema schema3 = new Validator().string().minLength(MIN_VALUE);

        assertTrue(schema3.isValid(LINE));
        assertTrue(schema3.isValid(LINE_NULL));
        assertTrue(schema3.isValid(LINE_EMPTY));

        StringSchema schema4 = new Validator().string().minLength(MAX_VALUE);

        assertFalse(schema4.isValid(LINE));
        assertTrue(schema4.isValid(LINE_NULL));
        assertTrue(schema4.isValid(LINE_EMPTY));
    }

    @Test
    void testContains() {
        StringSchema schema5 = new Validator().string().contains(LINE_TRUE);

        assertTrue(schema5.isValid(LINE));
        assertTrue(schema5.isValid(LINE_NULL));
        assertTrue(schema5.isValid(LINE_EMPTY));

        StringSchema schema6 = new Validator().string().contains(LINE_FALSE);

        assertFalse(schema6.isValid(LINE));
        assertTrue(schema6.isValid(LINE_NULL));
        assertTrue(schema6.isValid(LINE_EMPTY));
    }
}
