package Database_Access_Object;

public class Check_In {
    private String employees_sin;
    private String customers_sin;
    private String reference_number;

    public Check_In(String employees_sin, String customers_sin, String reference_number) {
        this.employees_sin = employees_sin;
        this.customers_sin = customers_sin;
        this.reference_number = reference_number;
    }

    public String getEmployees_sin() {
        return employees_sin;
    }

    public String getCustomers_sin() {
        return customers_sin;
    }

    public String getReference_number() {
        return reference_number;
    }

    public void setEmployees_sin(String employees_sin) {
        this.employees_sin = employees_sin;
    }

    public void setCustomers_sin(String customers_sin) {
        this.customers_sin = customers_sin;
    }

    public void setReference_number(String reference_number) {
        this.reference_number = reference_number;
    }

    @Override
    public String toString() {
        return "Check_In{" +
                "employees_sin='" + employees_sin + '\'' +
                ", customers_sin='" + customers_sin + '\'' +
                ", reference_number='" + reference_number + '\'' +
                '}';
    }
}
