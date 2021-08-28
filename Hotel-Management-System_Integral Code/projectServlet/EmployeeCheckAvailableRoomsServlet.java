package projectServlet;

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

public class EmployeeCheckAvailableRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access_Employees ae = new Access_Employees();
        ae.connect();

        HttpSession session = request.getSession();
        String employee_SIN = (String) request.getSession().getAttribute("employee_SIN");
        String hotel_address = (String) request.getSession().getAttribute("hotel_address");
        String checking_date = request.getParameter("Checking_Date");

        ArrayList<Rooms> availableRoomList = ae.checkAvailableRoom(hotel_address,checking_date);

        if(availableRoomList.size() == 0){
            request.setAttribute("message2","All the rooms are not available in this date.");
            request.getRequestDispatcher("EmployeeChoice.jsp").forward(request,response);
        }else{
            session.setAttribute("available_room_list",availableRoomList);
            session.setAttribute("employee_SIN",employee_SIN);
            session.setAttribute("hotel_address",hotel_address);
            response.sendRedirect("EmployeeCheckAvailableRooms.jsp");
        }

        ae.close();
        return;

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
