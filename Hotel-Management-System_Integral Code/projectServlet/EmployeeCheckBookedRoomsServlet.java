package projectServlet;

import Database_Access_Object.Access_BookingInfo;
import Database_Access_Object.Access_Employees;
import Database_Access_Object.BookingInfo;
import Database_Access_Object.Rooms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeCheckBookedRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access_Employees ae = new Access_Employees();
        ae.connect();

        HttpSession session = request.getSession();
        String employee_SIN = (String) request.getSession().getAttribute("employee_SIN");
        String hotel_address = (String) request.getSession().getAttribute("hotel_address");

        ArrayList<Rooms> bookedRoomList = ae.checkBookedRoom(hotel_address);
        ArrayList<BookingInfo> bookingInfoList = ae.checkBookingInfo(hotel_address);

        if(bookedRoomList.size() == 0){                                                  //go back to original page
            request.setAttribute("message1","All the rooms are not booked");      //assign value to "message"
            request.getRequestDispatcher("EmployeeChoice.jsp").forward(request,response);
        }else{                                      //redirect to a NEW page(Not include previous Parameter,so Null)
            session.setAttribute("booked_room_list",bookedRoomList);
            session.setAttribute("booking_info_list",bookingInfoList);
            session.setAttribute("employee_SIN",employee_SIN);
            session.setAttribute("hotel_address",hotel_address);
            response.sendRedirect("EmployeeCheckBookedRooms.jsp");
        }


        ae.close();
        return;

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
