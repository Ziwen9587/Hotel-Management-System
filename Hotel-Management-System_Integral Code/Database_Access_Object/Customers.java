package Database_Access_Object;

public class Customers {
    private String customer_sin;
    private String first_name;
    private String last_name;
    private String address;
    private String phone;
    private String date_of_registration;

    public Customers(String customer_sin, String first_name, String last_name, String address, String phone, String date_of_registration) {
        this.customer_sin = customer_sin;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.phone = phone;
        this.date_of_registration = date_of_registration;
    }

    public String getCustomer_sin() {
        return customer_sin;
    }

    public void setCustomer_sin(String customer_sin) {
        this.customer_sin = customer_sin;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(String date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_sin='" + customer_sin + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", date_of_registration='" + date_of_registration + '\'' +
                '}';
    }
}
