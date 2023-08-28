package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    private static final int MIN_VALUE = 5;
    private static final int MAX_VALUE = 25;

    private StringSchema schema;

    @BeforeEach
    public void getValidator() {
        Validator validator = new Validator();
        schema = validator.string();
    }

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullSource
    public void testStringSchemaEmpty(String line) {
        boolean actual1 = schema.isValid(line);
        assertTrue(actual1);

        boolean actual2 = schema.required().isValid(line);
        assertFalse(actual2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Winter is coming!"})
    public void testStringSchemaLine(String line) {
        boolean actual1 = schema.isValid(line);
        assertTrue(actual1);

        boolean actual2 = schema.required().contains(" is").minLength(MIN_VALUE).isValid(line);
        assertTrue(actual2);

        boolean actual3 = schema.minLength(MAX_VALUE).contains("no way").isValid(line);
        assertFalse(actual3);

        boolean actual4 = schema.minLength(MIN_VALUE).contains("no way").isValid(line);
        assertFalse(actual4);

        boolean actual5 = schema.minLength(MAX_VALUE).contains(" is").isValid(line);
        assertFalse(actual5);
    }
}
