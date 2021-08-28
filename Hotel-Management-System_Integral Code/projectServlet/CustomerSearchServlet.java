package projectServlet;
import Database_Access_Object.Access_Customers;
import Database_Access_Object.Access_Rooms;
import Database_Access_Object.Customers;
import Database_Access_Object.Rooms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Access_Rooms ar = new Access_Rooms();
        ar.connect();

        String city = request.getParameter("City");
        String roomCapacity = request.getParameter("Room_Capacity");
        String date = request.getParameter("Date");

        ArrayList<Rooms> roomSearchResultList = ar.searchCondition(city,roomCapacity,date);

        if(roomSearchResultList.size() == 0){                                                  //go back to original page
            request.setAttribute("message","Rooms do not exist");      //assign value to "message"
            request.getRequestDispatcher("CustomerSearch.jsp").forward(request,response);
        }else{                                      //redirect to a NEW page(Not include previous Parameter,so Null)
            HttpSession session = request.getSession();
            session.setAttribute("show_roomList",roomSearchResultList);
            session.setAttribute("city_name",city);
            session.setAttribute("room_capacity",roomCapacity);
            session.setAttribute("booking_date",date);
            response.sendRedirect("CustomerSearchRoomResult.jsp");

        }
        ar.close();
        return;

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
