/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import java.io.IOException;
import java.io.PrintWriter;
import Objects.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author louis
 */
@WebServlet(name = "makeAppointmentNotes", urlPatterns = {"/makeAppointmentNotes"})
public class makeAppointmentNotes extends HttpServlet {

    /**
     *makeAppointmentNotes serverlets, this is used to add notes to previously created appointments
     * <br><br>
     * First, an appID is retrived from the dropdown on the secretary page using the getParameter() method, the contents of the note is also captured in this way.
     * <br>
     * Next, a appointment is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the appointment that matches the ID retrived. If an appointment is found, the note is added and the object is serialized.
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
        try {
            String appID = request.getParameter("appDrop");
            String appNotes = request.getParameter("appNotes");
            Appointment app = new Appointment();            
            ArrayList<Appointment> getApps = app.deserialize();
            
            for(int i = 0; i < getApps.size(); i++)
            {
                if(getApps.get(i).getAppointmentID().equals(appID))                
                {
                    getApps.get(i).setAppointmentNotes(appNotes);
                    getApps.get(i).serialize();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(makeAppointmentNotes.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("doctorPanel.jsp");
    }
}
