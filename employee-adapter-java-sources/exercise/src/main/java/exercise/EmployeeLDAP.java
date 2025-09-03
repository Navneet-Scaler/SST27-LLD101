package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class EmployeeLDAP {
    private final Map<String, String> attributes;

    public EmployeeLDAP(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }
}
