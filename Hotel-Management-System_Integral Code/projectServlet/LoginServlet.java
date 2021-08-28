package projectServlet;
import Database_Access_Object.Access_Customers;
import Database_Access_Object.Customers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        String role = request.getParameter("role");             //Role: Employee, Manager, or Customer?

        if(role.equals("customer")){
            response.sendRedirect("CustomerSearch.jsp");
        } else {
            response.sendRedirect("LoginEmployee.jsp");
        }

        return;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        doPost(request,response);
    }
}
