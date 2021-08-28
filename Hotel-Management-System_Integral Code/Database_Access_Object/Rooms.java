package Database_Access_Object;

public class Rooms {
    private String hotelAddress;
    private String roomNumber;
    private String price;
    private String otherAmenities;
    private String roomCapacity;
    private String viewStyle;
    private String tv;
    private String airCondition;
    private String extendable;

    public Rooms(String hotelAddress, String roomNumber, String price, String otherAmenities, String roomCapacity, String viewStyle, String tv, String airCondition, String extendable) {
        this.hotelAddress = hotelAddress;
        this.roomNumber = roomNumber;
        this.price = price;
        this.otherAmenities = otherAmenities;
        this.roomCapacity = roomCapacity;
        this.viewStyle = viewStyle;
        this.tv = tv;
        this.airCondition = airCondition;
        this.extendable = extendable;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(String otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    public String getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(String roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getViewStyle() {
        return viewStyle;
    }

    public void setViewStyle(String viewStyle) {
        this.viewStyle = viewStyle;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public String getExtendable() {
        return extendable;
    }

    public void setExtendable(String extendable) {
        this.extendable = extendable;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "hotelAddress='" + hotelAddress + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", price='" + price + '\'' +
                ", otherAmenities='" + otherAmenities + '\'' +
                ", roomCapacity='" + roomCapacity + '\'' +
                ", viewStyle='" + viewStyle + '\'' +
                ", tv='" + tv + '\'' +
                ", airCondition='" + airCondition + '\'' +
                ", extendable='" + extendable + '\'' +
                '}';
    }
}
