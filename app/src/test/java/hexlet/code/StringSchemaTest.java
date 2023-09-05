package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    @Test
    void testIsValid() {
        final int number = 5;
        StringSchema schema1 = new Validator().string();

        assertTrue(schema1.isValid("Winter is coming!"));
        assertTrue(schema1.isValid(null));
        assertTrue(schema1.isValid(""));
        assertFalse(schema1.isValid(number));
    }

    @Test
    void testRequired() {
        StringSchema schema2 = new Validator().string().required();

        assertTrue(schema2.isValid("Winter is coming!"));
        assertFalse(schema2.isValid(null));
        assertFalse(schema2.isValid(""));
    }

    @Test
    void testMinLength() {
        final int number1 = 5;
        StringSchema schema3 = new Validator().string().minLength(number1);

        assertTrue(schema3.isValid("Winter is coming!"));
        assertTrue(schema3.isValid(null));
        assertFalse(schema3.isValid(""));
        assertFalse(schema3.isValid("home"));
    }

    @Test
    void testContains() {
        StringSchema schema4 = new Validator().string().contains(" is");

        assertTrue(schema4.isValid("Winter is coming!"));
        assertTrue(schema4.isValid(null));
        assertFalse(schema4.isValid(""));
        assertFalse(schema4.isValid("Jon Snow"));
    }
}
