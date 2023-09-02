package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    private static final Object ITEM_NULL = null;
    private static final int ITEM_BASIC = 31;
    private static final int ITEM_EXTREME = 109;
    private static final int ITEM_ZERO = 0;
    private static final int ITEM_NEGATIVE = -6;
    private static final String ITEM_LINE = "no way";

    private static final int NUMBER_FROM = 2;
    private static final int NUMBER_TO = 90;

    @Test
    void testIsValid() {
        NumberSchema schema1 = new Validator().number();

        assertTrue(schema1.isValid(ITEM_NULL));
        assertTrue(schema1.isValid(ITEM_BASIC));
        assertTrue(schema1.isValid(ITEM_ZERO));
        assertTrue(schema1.isValid(ITEM_NEGATIVE));
        assertFalse(schema1.isValid(ITEM_LINE));
    }

    @Test
    void testRequired() {
        NumberSchema schema2 = new Validator().number().required();

        assertFalse(schema2.isValid(ITEM_NULL));
        assertTrue(schema2.isValid(ITEM_BASIC));
        assertTrue(schema2.isValid(ITEM_ZERO));
        assertTrue(schema2.isValid(ITEM_NEGATIVE));
    }

    @Test
    void testPositive() {
        NumberSchema schema3 = new Validator().number().positive();

        assertTrue(schema3.isValid(ITEM_NULL));
        assertTrue(schema3.isValid(ITEM_BASIC));
        assertFalse(schema3.isValid(ITEM_ZERO));
        assertFalse(schema3.isValid(ITEM_NEGATIVE));
    }

    @Test
    void testRange() {
        NumberSchema schema4 = new Validator().number().range(NUMBER_FROM, NUMBER_TO);

        assertTrue(schema4.isValid(ITEM_NULL));
        assertTrue(schema4.isValid(ITEM_BASIC));
        assertFalse(schema4.isValid(ITEM_ZERO));
        assertFalse(schema4.isValid(ITEM_NEGATIVE));
        assertFalse(schema4.isValid(ITEM_EXTREME));
    }
}
