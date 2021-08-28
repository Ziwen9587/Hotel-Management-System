package Database_Access_Object;


public class Renting {
    private String customerSin;
    private String hotelAddress;
    private String roomNumber;
    private String employeesSin;
    private String payment;
    private String startDate;
    private String endDate;

    public Renting(String customerSin, String hotelAddress, String roomNumber, String employeesSin, String payment, String startDate, String endDate) {
        this.customerSin = customerSin;
        this.hotelAddress = hotelAddress;
        this.roomNumber = roomNumber;
        this.employeesSin = employeesSin;
        this.payment = payment;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCustomerSin() {
        return customerSin;
    }

    public void setCustomerSin(String customerSin) {
        this.customerSin = customerSin;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getEmployeesSin() {
        return employeesSin;
    }

    public void setEmployeesSin(String employeesSin) {
        this.employeesSin = employeesSin;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Renting{" +
                "customerSin='" + customerSin + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", employeesSin='" + employeesSin + '\'' +
                ", payment='" + payment + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
