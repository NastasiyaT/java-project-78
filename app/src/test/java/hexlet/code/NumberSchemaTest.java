package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberSchemaTest {

    @Test
    void testIsValid() {
        final int number = 31;
        final int zero = 0;
        final int negative = -6;

        NumberSchema schema1 = new Validator().number();

        assertTrue(schema1.isValid(null));
        assertTrue(schema1.isValid(number));
        assertTrue(schema1.isValid(zero));
        assertTrue(schema1.isValid(negative));
        assertFalse(schema1.isValid("no way"));
    }

    @Test
    void testRequired() {
        final int number = 31;
        final int zero = 0;
        final int negative = -6;

        NumberSchema schema2 = new Validator().number().required();

        assertFalse(schema2.isValid(null));
        assertTrue(schema2.isValid(number));
        assertTrue(schema2.isValid(zero));
        assertTrue(schema2.isValid(negative));
    }

    @Test
    void testPositive() {
        final int number = 31;
        final int zero = 0;
        final int negative = -6;

        NumberSchema schema3 = new Validator().number().positive();

        assertTrue(schema3.isValid(null));
        assertTrue(schema3.isValid(number));
        assertFalse(schema3.isValid(zero));
        assertFalse(schema3.isValid(negative));
    }

    @Test
    void testRange() {
        final int number = 31;
        final int numberFalse = 109;
        final int zero = 0;
        final int negative = -6;

        final int min = 2;
        final int max = 90;
        NumberSchema schema4 = new Validator().number().range(min, max);

        assertTrue(schema4.isValid(null));
        assertTrue(schema4.isValid(number));
        assertFalse(schema4.isValid(zero));
        assertFalse(schema4.isValid(negative));
        assertFalse(schema4.isValid(numberFalse));
    }
}
