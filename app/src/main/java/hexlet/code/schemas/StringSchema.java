package hexlet.code.schemas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringSchema implements Schema {
    private boolean validationResult = true;
    private String line;

    public boolean isValid(Object obj) {
        if (obj != null) {
            line = obj.toString();
        }
        return validationResult;
    }

    public StringSchema required() {
        if (line == null || line.isEmpty()) {
            validationResult = false;
        }
        return this;
    }

    public StringSchema minLength(int length) {
        if (line.length() < length) {
            validationResult = false;
        }
        return this;
    }

    public StringSchema contains(String phrase) {
        if (!line.contains(phrase)) {
            validationResult = false;
        }
        return this;
    }
}
