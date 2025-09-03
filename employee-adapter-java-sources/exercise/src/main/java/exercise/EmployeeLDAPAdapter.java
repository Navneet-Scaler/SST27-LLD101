package exercise;

public class EmployeeLDAPAdapter implements Employee {
    private final EmployeeLDAP instance;

    public EmployeeLDAPAdapter(EmployeeLDAP instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.getAttribute("uid");
    }

    @Override
    public String getFirstName() {
        return instance.getAttribute("givenName");
    }

    @Override
    public String getLastName() {
        return instance.getAttribute("sn");
    }

    @Override
    public String getEmail() {
        return instance.getAttribute("mail");
    }
}
