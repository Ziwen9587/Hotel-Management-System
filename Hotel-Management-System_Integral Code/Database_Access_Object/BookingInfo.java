package Database_Access_Object;

public class BookingInfo {

    private String customerSin;
    private String referenceNumber;
    private String bookingDate;
    private String numberOfOccupants;
    private String additionComment;
    private String hotelAddress;
    private String roomNumber;

    public BookingInfo(String customerSin, String referenceNumber, String bookingDate, String numberOfOccupants, String additionComment, String hotelAddress, String roomNumber) {
        this.customerSin = customerSin;
        this.referenceNumber = referenceNumber;
        this.bookingDate = bookingDate;
        this.numberOfOccupants = numberOfOccupants;
        this.additionComment = additionComment;
        this.hotelAddress = hotelAddress;
        this.roomNumber = roomNumber;
    }

    public String getCustomerSin() {
        return customerSin;
    }

    public void setCustomerSin(String customerSin) {
        this.customerSin = customerSin;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(String numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    public String getAdditionComment() {
        return additionComment;
    }

    public void setAdditionComment(String additionComment) {
        this.additionComment = additionComment;
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

    @Override
    public String toString() {
        return "BookingInfo{" +
                "customerSin='" + customerSin + '\'' +
                ", referenceNumber='" + referenceNumber + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", numberOfOccupants='" + numberOfOccupants + '\'' +
                ", additionComment='" + additionComment + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}

