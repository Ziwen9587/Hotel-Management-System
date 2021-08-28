package Database_Access_Object;

import java.sql.SQLException;
import java.util.ArrayList;

public class Access_Rooms extends SuperConnection{

    public ArrayList<Rooms> selectAll() {               //Method#1_Select ALL
        ArrayList<Rooms> roomsList = new ArrayList<Rooms>();
        try {
            querySQL = "select * from project.rooms";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {
                String hotelAddress = rs.getString(1);
                String roomNumber = rs.getString(2);
                String price = rs.getString(3);
                String otherAmenities = rs.getString(4);
                String roomCapacity = rs.getString(5);
                String viewStyle = rs.getString(6);
                String tv  = rs.getString(7);
                String airCondition  = rs.getString(8);
                String extendable  = rs.getString(9);

                Rooms currentRooms = new Rooms(hotelAddress,roomNumber,price,otherAmenities,roomCapacity,viewStyle,tv,airCondition,extendable);
                roomsList.add(currentRooms);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomsList;
    }

    public ArrayList<Rooms> searchCondition (String city, String room_capacity, String date){         //Method#2_Select Condition
        Rooms rooms = null;
        ArrayList<Rooms> roomsList= new ArrayList<Rooms>();
        try{
            querySQL = "select * from project.rooms where room_capacity >= "
                        + "\'" + room_capacity + "\'"
                        + "and hotel_address like " + "\'" + "%" + city + "%" + "\'"
                        + "and" + "((hotel_address,room_number) not in (select hotel_address,room_number from project.renting "
                        + "where start_date <= " + "\'" + date + "\'"
                        + "and end_date >= " + "\'" + date + "\'" +")" + ")"
                        + "and " + "((hotel_address,room_number) not in (select hotel_address,room_number from project.booking_info "
                        + "where booking_date = " + "\'" + date + "\'" + ")"+ ")";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while(rs.next()){
                String hotelAddress = rs.getString(1);;
                String roomNumber = rs.getString(2);
                String price = rs.getString(3);
                String otherAmenities = rs.getString(4);
                String roomCapacity = rs.getString(5);
                String viewStyle = rs.getString(6);
                String tv = rs.getString(7);
                String airCondition = rs.getString(8);
                String extendable = rs.getString(9);

                rooms = new Rooms(hotelAddress,roomNumber,price,otherAmenities,roomCapacity,viewStyle,tv,airCondition,extendable);
                roomsList.add(rooms);
            }
        } catch (SQLException e){
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
                e.printStackTrace();
        }
        return roomsList;
        }

}
