/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Users.*;
import java.io.FileNotFoundException;
import java.io.IOException;
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
@WebServlet(name = "requestTermination", urlPatterns = {"/requestTermination"})
public class requestTermination extends HttpServlet {

    /**
     *requestTermination serverlet, this is used by the patient to request termination of their account
     * <br><br>
     * First, a HttpSession object is created based on the current session
     * <br>
     * Next, a userID string is defined from the attribute stored in the session variable "userID"
     * <br>
     * Next, a patient is created and an arraylist is generated from its deserialize() method
     * <br>
     * Next, a for loop is used to itterate through the array to find the User that matches the user ID captured. If a user is found, their requestedTermination boolean is set to true.
     * <br>
     * Finally, the patient is serialized and the user is redirected back to the login page
     * @param request - gets request information from previous page
     * @param response - gets response information from previous page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
                HttpSession session = request.getSession();
        try {
            String userID = session.getAttribute("userID").toString();
            Patient pat = new Patient();
            ArrayList<Patient> termStore = pat.deserialize();
            
            for(int i = 0; i < termStore.size(); i++)
            {
                if(termStore.get(i).getPatientID().equals(userID))
                {
                    termStore.get(i).setPatientRequestedTermination(true);
                    termStore.get(i).serialize();
                }
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(requestTermination.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(requestTermination.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       response.sendRedirect("login.jsp");
    }
}
