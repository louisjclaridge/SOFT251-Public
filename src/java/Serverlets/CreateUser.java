/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Users.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author louis
 */
@WebServlet(name = "CreateUser", urlPatterns = {"/CreateUser"})
public class CreateUser extends HttpServlet {

    /**
     * CreateUser Serverlet, this is used to create a user based upon information inputed on the create user page
     * <br><br>
     * First, all relevant attributes are retrieved from the CreateUser.jsp page using the getParameter() method.
     * <br>
     * Next, a check is made to determine what the first letter of the ID is, this is to make sure that the correct user object is created. If no correct prefix is found, the user is simply redirected back to CreateUser.jsp
     * <br>
     * Next, the correct user object is created using previously defined varriables and user specific varriables.
     * <br>
     * Finally, the object is being serialized using the serialization method built into the object and the user is redirected back to the create user page
     * @param request - gets request information from previous page
     * @param response - gets response information from previous page
     * @throws IOException
     * @throws FileNotFoundException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, FileNotFoundException
    {
        String firstname = request.getParameter("FirstName");
        String lastname = request.getParameter("LastName");
        String address = request.getParameter("Address");
        String gender = request.getParameter("Gender");
        String dob = request.getParameter("Dateofbirth");
        String id = request.getParameter("ID");
        String password = request.getParameter("Password");

        
            if(id.substring(0, 1) .contains("P"))
            {
                Patient patient = new Patient(firstname, lastname, address, gender, dob, id, password, false, false);
                try 
                {
                patient.serialize();
                }
                catch (ClassNotFoundException ex) 
                {
                    System.out.println("Cannot Serialize");
                }
            }
          
            if(id.substring(0, 1) .contains("D"))
            {
                Doctor doctor = new Doctor(firstname, lastname, address, gender, dob, id, password, 0.0);
                try 
                {
                doctor.serialize();
                }
                catch (ClassNotFoundException ex) 
                {
                    System.out.println("Cannot Serialize");
                }
            }
            
            if(id.substring(0, 1) .contains("A"))
            {
                Administrator admin = new Administrator(firstname, lastname, address, gender, dob, id, password);
                try 
                {
                admin.serialize();
                }
                catch (ClassNotFoundException ex) 
                {
                    System.out.println("Cannot Serialize");
                }
            }
            
            if(id.substring(0, 1) .contains("S"))
            {
                Secretary secretary = new Secretary(firstname, lastname, address, gender, dob, id, password, new ArrayList());
                try 
                {
                secretary.serialize();
                }
                catch (ClassNotFoundException ex) 
                {
                    System.out.println("Cannot Serialize");
                }
            }
            response.sendRedirect("CreateUser.jsp");
            }
    }
