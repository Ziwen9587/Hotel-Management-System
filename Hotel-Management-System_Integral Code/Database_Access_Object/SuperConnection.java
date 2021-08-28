package Database_Access_Object;
import java.io.*;
import java.sql.*;
import java.util.Arrays;


public class SuperConnection {
    protected Connection dbConnection;
    protected String querySQL;
    protected Statement st;
    protected ResultSet rs;

    protected String url;
    protected String dbUserName;
    protected String dbUserPassWord;

    public  SuperConnection(){
        url = "jdbc:postgresql://web0.site.uottawa.ca:15432/group_a02_g19";
        dbUserName = "A02_Group#19";
        dbUserPassWord = "";
    }

    public void connect(){
        try{
            Class.forName("org.postgresql.Driver");
            dbConnection = DriverManager.getConnection(url,dbUserName,dbUserPassWord);
        } catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            st.close();
            if(rs != null){
                rs.close();
            }
            dbConnection.close();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
