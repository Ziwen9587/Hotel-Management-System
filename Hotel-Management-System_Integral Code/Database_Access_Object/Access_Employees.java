package Database_Access_Object;

import java.sql.SQLException;
import java.util.ArrayList;

public class Access_Employees extends SuperConnection{

    public ArrayList<Employees> selectAll() {               //Method#1_Select ALL
        ArrayList<Employees> employeesList = new ArrayList<>();
        try {
            querySQL = "select * from project.employees";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {
                String employeesSin = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String salary = rs.getString(4);
                String address = rs.getString(5);
                String hotelAddress = rs.getString(6);

                Employees currentEmployee = new Employees(employeesSin,firstName,lastName,salary,address,hotelAddress);
                employeesList.add(currentEmployee);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeesList;
    }

    public Employees searchCondition (String employees_sin, String hotel_address){         //Method#2_Select Condition
        Employees employees = null;
        try{
            querySQL = "select * from project.employees where employees_sin = " + "\'" + employees_sin + "\'"
                    + " and hotel_address = " + "\'" + hotel_address + "\'";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            if(rs.next()){
                String employeesSin = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String salary = rs.getString(4);
                String address = rs.getString(5);
                String hotelAddress = rs.getString(6);

                employees = new Employees(employeesSin,firstName, lastName, salary, address, hotelAddress);
                return employees;
            } else {
                System.out.println("The target does not exist");
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return employees;
    }

    public ArrayList<Rooms> checkBookedRoom(String hotel_address){
        Rooms rooms = null;
        ArrayList<Rooms> bookedRoomList = new ArrayList<Rooms>();
        try{
            querySQL = "select * from project.rooms where hotel_address = " +"\'" + hotel_address +"\'"
                        + " and " + "(hotel_address,room_number) in (select hotel_address,room_number from project.booking_info)";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while(rs.next()){

                String roomNumber = rs.getString(2);
                String price = rs.getString(3);
                String otherAmenities = rs.getString(4);
                String roomCapacity = rs.getString(5);
                String viewStyle = rs.getString(6);
                String tv = rs.getString(7);
                String airCondition = rs.getString(8);
                String extendable = rs.getString(9);

                rooms = new Rooms(hotel_address,roomNumber,price,otherAmenities,roomCapacity,viewStyle,tv,airCondition,extendable);
                bookedRoomList.add(rooms);
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return bookedRoomList;
    }

    public ArrayList<Rooms> checkAvailableRoom(String hotel_address,String checking_date){
        Rooms rooms = null;
        ArrayList<Rooms> bookedRoomList = new ArrayList<Rooms>();
        try{
            querySQL = "select * from project.rooms where hotel_address = " + "\'" + hotel_address + "\'"
                    + "and ((hotel_address,room_number) not in (select hotel_address,room_number from project.renting "
                    + "where start_date <= " + "\'" + checking_date + "\'"
                    + "and end_date >= " + "\'" + checking_date + "\'" +")" + ")"
                    + "and " + "((hotel_address,room_number) not in (select hotel_address,room_number from project.booking_info "
                    + "where booking_date = " + "\'" + checking_date + "\'" + ")"+ ")";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while(rs.next()){
                String roomNumber = rs.getString(2);
                String price = rs.getString(3);
                String otherAmenities = rs.getString(4);
                String roomCapacity = rs.getString(5);
                String viewStyle = rs.getString(6);
                String tv = rs.getString(7);
                String airCondition = rs.getString(8);
                String extendable = rs.getString(9);

                rooms = new Rooms(hotel_address,roomNumber,price,otherAmenities,roomCapacity,viewStyle,tv,airCondition,extendable);
                bookedRoomList.add(rooms);
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return bookedRoomList;
    }

    public ArrayList<BookingInfo> checkBookingInfo(String hotel_address){
        BookingInfo bookingInfo = null;
        ArrayList<BookingInfo> bookingInfoList = new ArrayList<BookingInfo>();
        try{
            querySQL = "select * from project.booking_info where hotel_address = " +"\'" + hotel_address +"\'";
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


    public Renting insertRenting (String customer_sin, String hotel_address, String room_number, String employees_sin, String payment, String start_date, String end_date){
        Renting renting = null;

        try{
            querySQL = "select * from project.booking_info where customer_sin = "
                        + "\'" + customer_sin + "\'" + " and hotel_address = "
                        + "\'" + hotel_address + "\'" + " and room_number = "
                        + room_number;
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);

            if (rs.next()){

                querySQL = "insert into project.renting values " + "("
                        + "\'" + customer_sin + "\'" + ","
                        + "\'" + hotel_address + "\'" +","
                        + room_number + ","
                        + "\'" + employees_sin + "\'" + ","
                        + payment + ","
                        + "\'" + start_date + "\'" + ","
                        + "\'" + end_date + "\'" + ")";
                st = dbConnection.createStatement();

                int checkUpdate  = st.executeUpdate(querySQL);              //*****Note:executeUpdate used for DDL
                System.out.println(checkUpdate);
                if(checkUpdate != 0){

                    renting = new Renting(customer_sin,hotel_address,room_number,employees_sin,payment,start_date,end_date);
                    return renting;
                } else {
                    System.out.println("Insertion is failed");
                }
            }  else {
                    return renting;
            }

        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return renting;
    }

    public Renting nonBookedToRenting (String customer_sin, String hotel_address, String room_number, String employees_sin, String payment, String start_date, String end_date){
        Renting renting = null;

        try{
            querySQL = "insert into project.renting values " + "("
                        + "\'" + customer_sin + "\'" + ","
                        + "\'" + hotel_address + "\'" +","
                        + room_number + ","
                        + "\'" + employees_sin + "\'" + ","
                        + payment + ","
                        + "\'" + start_date + "\'" + ","
                        + "\'" + end_date + "\'" + ")";
            st = dbConnection.createStatement();

            int checkUpdate  = st.executeUpdate(querySQL);              //*****Note:executeUpdate used for DDL
            if(checkUpdate != 0){
                renting = new Renting(customer_sin,hotel_address,room_number,employees_sin,payment,start_date,end_date);
                return renting;
            } else {
                System.out.println("Insertion is failed");
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return renting;
    }


}
