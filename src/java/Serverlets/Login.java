/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Users.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author louis
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     *Login Serverlet, this is used to manage access to the system by created users
     * <br><br>
     * First, the Username and Password values are retrived from the login page using the getParameter() method
     * <br>
     * Next, a check is made to determine the first letter of the Users ID, this allows the proper handling of user access and which page to navigate to.
     * <br>
     * Next, a user object based on the correct user is generated, this is used to access the deserialize() method of the user object.
     * <br>
     * Next, an arraylist is created based on the output of the deserialize() method of the instantiated object
     * <br>
     * Next, a for loop is used to itterate through each item in the arraylist checking to see if the username and password is correct based on the current user selected in the ArrayList
     * <br>
     * Finally, once a correct user has been found, the user is redirected to the appropriate page for their user type.
     * @param request - gets request information from previous page
     * @param response - gets response information from previous page
     * @throws ServletException
     * @throws IOException
     * @throws FileNotFoundException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException
    {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username.substring(0, 1).contains("P"))
        {
            Patient p = new Patient();
            ArrayList<Patient> storePatient = new ArrayList<>();
            try {
                storePatient = p.deserialize();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(int i = 0; i < storePatient.size(); i++)
            {
                String uCheck = storePatient.get(i).getPatientID();
                String pCheck = storePatient.get(i).getPatientPassword();
                if(uCheck.equals(username) && pCheck.equals(password))
                {
                   session.setAttribute("userID", uCheck);
                   response.sendRedirect("patientPanel.jsp");
                   return;
                }
                else
                {
                   response.sendRedirect("index.jsp");
                   return;
                }
            }
        }
      
        if(username.substring(0, 1).contains("D"))
        {
            Doctor d = new Doctor();
            ArrayList<Doctor> storeDoctor = new ArrayList<>();
            try {
                storeDoctor = d.deserialize();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(int i = 0; i < storeDoctor.size(); i++)
            {
                String uCheck = storeDoctor.get(i).getDoctorID();
                String pCheck = storeDoctor.get(i).getDoctorPassword();
                if(uCheck.equals(username) && pCheck.equals(password))
                {
                   session.setAttribute("userID", uCheck);            
                   response.sendRedirect("doctorPanel.jsp");
                   return;
                }
                else
                {
                   response.sendRedirect("login.jsp");
                   return;
                }
            }
        }
        
        if(username.substring(0, 1).contains("A"))
        {
            Administrator a = new Administrator();
            ArrayList<Administrator> storeAdmin = new ArrayList<>();
            try {
                storeAdmin = a.deserialize();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(int i = 0; i < storeAdmin.size(); i++)
            {
                String uCheck = storeAdmin.get(i).getAdministratorID();
                String pCheck = storeAdmin.get(i).getAdministratorPassword();
                if(uCheck.equals(username) && pCheck.equals(password))
                {
                   session.setAttribute("userID", uCheck);
                   response.sendRedirect("adminPanel.jsp");
                   return;
                }
                else
                {
                   response.sendRedirect("login.jsp");
                   return;
                }
            }
        }
        
        if(username.substring(0, 1).contains("S"))
        {
            Secretary s = new Secretary();
            ArrayList<Secretary> storeSec = new ArrayList<>();
            try {
                storeSec = s.deserialize();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            for(int i = 0; i < storeSec.size(); i++)
            {
                String uCheck = storeSec.get(i).getSecretaryID();
                String pCheck = storeSec.get(i).getSecretaryPassword();
                if(uCheck.equals(username) && pCheck.equals(password))
                {
                   session.setAttribute("userID", uCheck);            
                   response.sendRedirect("secretaryPanel.jsp");
                   return;
                }
                else
                {
                  response.sendRedirect("login.jsp");
                   return;
                }
            }
        }
        }
    }
