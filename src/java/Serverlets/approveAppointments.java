/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Objects.*;
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
@WebServlet(name = "approveAppointments", urlPatterns = {"/approveAppointments"})
public class approveAppointments extends HttpServlet {

    /**
     *approveAppointment serverlets, this is used to approve appointments made by either a doctor or patient
     * <br><br>
     * First, an appID is retrived from the dropdown on the secretary page using the getParameter() method
     * <br>
     * Next, a appointment is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the appointment that matches the ID retrived. If an appointment is found, it is then approved and serialized.
     * <br>
     * Finally, the secretary is redirected back to their panel
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
        if (null != request.getParameter("approve"))
        {
        try {
            String appID = request.getParameter("appApproveDrop");
            Appointment a = new Appointment();
            
            ArrayList<Appointment> storeApp = a.deserialize();
            
            for(int i = 0; i < storeApp.size(); i++)
            {
                if(storeApp.get(i).getAppointmentID().equals(appID))
                {
                    storeApp.get(i).setAppointmentApproved(true);
                    storeApp.get(i).serialize();
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(approveAppointments.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if (null != request.getParameter("reject"))
        {
           try {
            String appID = request.getParameter("appApproveDrop");
            Appointment a = new Appointment();
            
            ArrayList<Appointment> storeApp = a.deserialize();
            
            for(int i = 0; i < storeApp.size(); i++)
            {
                if(storeApp.get(i).getAppointmentID().equals(appID))
                {
                    storeApp.get(i).remove(storeApp.get(i).getAppointmentID());
                    storeApp.get(i).serialize();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(approveAppointments.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        response.sendRedirect("secretaryPanel.jsp");
    }

}
