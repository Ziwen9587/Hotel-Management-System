package Database_Access_Object;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ArrayList;


public class Access_Customers extends SuperConnection{

    public ArrayList<Customers> selectAll() {               //Method#1_Select ALL
        ArrayList<Customers> customersList = new ArrayList<>();
        try {
            querySQL = "select * from project.customers";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            while (rs.next()) {
                String customer_sin = rs.getString(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String address = rs.getString(4);
                String date_of_registration = rs.getString(5);
                String phone = rs.getString(6);
                Customers currentCustomers = new Customers(customer_sin, first_name, last_name, address, phone, date_of_registration);
                customersList.add(currentCustomers);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customersList;
    }

    public Customers searchCondition (String customer_sin){         //Method#2_Select Condition
        Customers customer = null;
        try{
            querySQL = "select * from project.customers where customer_sin = " + "\'" + customer_sin + "\'";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
            if(rs.next()){
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String address = rs.getString(4);
                String date_of_registration = rs.getString(5);
                String phone = rs.getString(6);
                customer = new Customers(customer_sin,first_name, last_name, address, phone, date_of_registration);
                return customer;
            } else {
                System.out.println("The target does not exist");
            }
        } catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    public void Insert (String customer_sin, String first_name, String last_name, String address, String phone, String date_of_registration){
        try{
            querySQL = "Inesrt into project.customers values" + "("
                    + "\'" + customer_sin + "\'" + ","
                    + "\'" + first_name + "\'" + ","
                    + "\'" + last_name + "\'" + ","
                    + "\'" + address + "\'" + ","
                    + "\'" + phone + "\'" + ","
                    + "\'" + date_of_registration + "\'" + ")";
            st = dbConnection.createStatement();
            rs = st.executeQuery(querySQL);
        }catch (SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch ( Exception e){
            e.printStackTrace();
        }
    }

}
