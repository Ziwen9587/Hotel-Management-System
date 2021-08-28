package projectServlet;

import Database_Access_Object.Access_Employees;
import Database_Access_Object.Employees;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EmployeeLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Access_Employees ae = new Access_Employees();
        ae.connect();
        String employeeSIN = request.getParameter("SIN");
        String hotelAddress = request.getParameter("Hotel_Address");

        Employees employees = ae.searchCondition(employeeSIN,hotelAddress);

        if(employees == null){                                                  //go back to original page
            request.setAttribute("message","Failed, please enter your valid SIN and matched Hotel Address");      //assign value to "message"
            request.getRequestDispatcher("LoginEmployee.jsp").forward(request,response);
        }else{                                      //redirect to a NEW page(Not include previous Parameter,so Null)
            HttpSession session = request.getSession();
            session.setAttribute("employee_SIN",employeeSIN);
            session.setAttribute("hotel_address",hotelAddress);
            response.sendRedirect("EmployeeChoice.jsp");
        }
        ae.close();

        return;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
