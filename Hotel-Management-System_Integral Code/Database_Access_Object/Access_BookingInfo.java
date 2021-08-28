package Database_Access_Object;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Access_BookingInfo extends SuperConnection{

    public ArrayList<BookingInfo> selectAll() {               //Method#1_Select ALL
        ArrayList<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
        try {
            querySQL = "select * from project.booking_info";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {

                String customerSin = rs.getString(1);;
                String referenceNumber  = rs.getString(2);;
                String bookingDate = rs.getString(3);;
                String numberOfOccupants = rs.getString(4);;
                String additionComment = rs.getString(5);;
                String hotelAddress = rs.getString(6);;
                String roomNumber = rs.getString(7);;

                BookingInfo bookingInfo = new BookingInfo(customerSin,referenceNumber,bookingDate,numberOfOccupants,additionComment,hotelAddress,roomNumber);
                bookingInfoList.add(bookingInfo);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingInfoList;
    }

    public ArrayList<BookingInfo> searchCondition (String customer_sin, String reference_number){         //Method#2_Select Condition
        BookingInfo bookingInfo = null;
        ArrayList<BookingInfo> bookingInfoList= new ArrayList<BookingInfo>();
        try{
            querySQL = "select * from project.booking_info where customer_sin = "
                    + "\'" + customer_sin + "\'"
                    + "and reference_number = " + "\'" + reference_number + "\'";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while(rs.next()){
                String customerSin = rs.getString(1);
                String referenceNumber = rs.getString(2);
                String bookingDate = rs.getString(3);
                String numberOfOccupants = rs.getString(4);
                String additionComment = rs.getString(5);
                String hotelAddress = rs.getString(6);
                String roomNumber = rs.getString(7);

                bookingInfo = new BookingInfo(customerSin,referenceNumber,bookingDate,numberOfOccupants,additionComment,hotelAddress,roomNumber);
                bookingInfoList.add(bookingInfo);
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return bookingInfoList;
    }

    public String generateReferenceNumber (){
        int intReferenceNumber = ThreadLocalRandom.current().nextInt(1, 15000);
        String referenceNumber = String.valueOf(intReferenceNumber);
        try{
            querySQL = "select * from project.booking_info where reference_number = "  + referenceNumber ;
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);

            boolean flag = true;
            while(flag){
                if(rs.next()){
                    intReferenceNumber = ThreadLocalRandom.current().nextInt(1, 15000);
                    referenceNumber = String.valueOf(intReferenceNumber);
                    rs = st.executeQuery(querySQL);
                } else {
                    flag = false;
                }
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return referenceNumber;
    }

    public String getHotelAddress (String city,String room_number,String street_number){
        String hotelAddress = null;
        try{
            querySQL = "select hotel_address from project.rooms where room_number = "
                        + room_number + " and "
                        + "hotel_address like " + "\'" + "%" + city + "%" + "\'"+ " and "
                        + "hotel_address like " + "\'" + "%" + street_number + "%" + "\'";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            rs.next();
            hotelAddress = rs.getString(1);
            boolean flag = true;
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return hotelAddress;
    }

    public BookingInfo insert (String customerSin, String referenceNumber, String bookingDate, String numberOfOccupants, String additionComment, String hotelAddress, String roomNumber){
        BookingInfo bookingInfo = null;

        try{
            querySQL = "select * from project.rooms where (hotel_address,room_number) = "
                    + "(" + "\'" + hotelAddress + "\'" + "," +  roomNumber +  ")"
                    + "and ((hotel_address,room_number) not in (select hotel_address,room_number from project.renting "
                    + "where start_date <= " + "\'" + bookingDate + "\'"
                    + "and end_date >= " + "\'" + bookingDate + "\'" +")" + ")"
                    + "and " + "((hotel_address,room_number) not in (select hotel_address,room_number from project.booking_info "
                    + "where booking_date <= " + "\'" + bookingDate + "\'" + ")"+ ")";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            if(rs.next()){
                querySQL = "insert into project.booking_info values " + "("
                        + "\'" + customerSin + "\'" + ","
                        + referenceNumber + ","
                        + "\'" + bookingDate + "\'" + ","
                        + numberOfOccupants + ","
                        + "\'" + additionComment + "\'" + ","
                        + "\'" + hotelAddress + "\'" + ","
                        + roomNumber + ")";
                st = dbConnection.createStatement();
                int checkUpdate  = st.executeUpdate(querySQL);              //*****Note:executeUpdate used for DDL
                if(checkUpdate != 0){
                    bookingInfo = new BookingInfo(customerSin,referenceNumber,bookingDate,numberOfOccupants,additionComment,hotelAddress,roomNumber);
                }
                return bookingInfo;
            } else {
                return bookingInfo;
            }

        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return bookingInfo;
    }

}

