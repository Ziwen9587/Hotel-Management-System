package Database_Access_Object;

public class Employees {
    protected String employeesSin;
    protected String firstName;
    protected String lastName;
    protected String salary;
    protected String address;
    protected String hotelAddress;

    public Employees(String employeesSin, String firstName, String lastName, String salary, String address, String hotelAddress) {
        this.employeesSin = employeesSin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
        this.hotelAddress = hotelAddress;
    }

    public String getEmployeesSin() {
        return employeesSin;
    }

    public void setEmployeesSin(String employeesSin) {
        this.employeesSin = employeesSin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Override
    public String toString() {
        return "employees{" +
                "employeesSin='" + employeesSin + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                '}';
    }
}

