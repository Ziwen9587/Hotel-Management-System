package projectServlet;

import Database_Access_Object.Access_Employees;
import Database_Access_Object.BookingInfo;
import Database_Access_Object.Renting;
import Database_Access_Object.Rooms;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeTransferBookedRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access_Employees ae = new Access_Employees();
        ae.connect();

        HttpSession session = request.getSession();
        String employeeSIN = (String) request.getSession().getAttribute("employee_SIN");
        String hotelAddress = (String) request.getSession().getAttribute("hotel_address");

        String customerSIN = request.getParameter("Customer_SIN");
        String roomNumber = request.getParameter("Room_Number");
        String payment = request.getParameter("Payment");
        String startDate = request.getParameter("Start_Date");
        String endDate = request.getParameter("End_Date");

        Renting transferRentingResult = ae.insertRenting(customerSIN,hotelAddress,roomNumber,employeeSIN,payment,startDate,endDate);

        if(transferRentingResult == null){                                                  //go back to original page
            request.setAttribute("message1","Transfer Failed, Please Carefully Enter The Matched Info From Booked Room List Below");      //assign value to "message"
            request.getRequestDispatcher("EmployeeCheckBookedRooms.jsp").forward(request,response);
        }else{                                      //redirect to a NEW page(Not include previous Parameter,so Null)
            session.setAttribute("customer_SIN", customerSIN);
            session.setAttribute("room_number", roomNumber);
            session.setAttribute("payment", payment);
            session.setAttribute("start_date", startDate);
            session.setAttribute("end_date", endDate);
            session.setAttribute("employee_SIN",employeeSIN);
            session.setAttribute("hotel_address",hotelAddress);
            session.setAttribute("transfer_renting_result",transferRentingResult);
            response.sendRedirect("EmployeeTransferRoomsResult.jsp");
        }
        ae.close();
        return;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
