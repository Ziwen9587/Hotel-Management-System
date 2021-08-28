package projectServlet;
import Database_Access_Object.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CustomerEndBookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Access_BookingInfo ab = new Access_BookingInfo();
        ab.connect();

        HttpSession session = request.getSession();
        String city = (String) request.getSession().getAttribute("city_name");
        String room_capacity = (String) request.getSession().getAttribute("room_capacity");
        String bookingDate = (String) request.getSession().getAttribute("booking_date");

        String sin = request.getParameter("SIN");
        String roomNumber = request.getParameter("Room_Number");
        String street_number = request.getParameter("Street_Number");
        String additional_comments = request.getParameter("Additional_Comments");
        String reference_number = ab.generateReferenceNumber();
        String hotel_address = ab.getHotelAddress(city,roomNumber,street_number);

        BookingInfo bookingInfo = ab.insert(sin,reference_number,bookingDate,room_capacity,additional_comments,hotel_address,roomNumber);
        System.out.println(ab);

        if(bookingInfo == null){
            request.setAttribute("message","Booking is failed, please use the valid SIN, Street Number, and Room Number.");
            request.getRequestDispatcher("CustomerSearchRoomResult.jsp").forward(request,response);
        }else{
            session.setAttribute("message","Congratulations! Room booking is successful!");
            response.sendRedirect("CustomerEndBooking.jsp");
        }

        ab.close();
        return;

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}


