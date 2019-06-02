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
import java.util.*;
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
@WebServlet(name = "approvePatient", urlPatterns = {"/approvePatient"})
public class approvePatient extends HttpServlet {

    /**
     *approveAppointment serverlets, this is used to approve patients that have been created
     * <br><br>
     * First, an patientID is retrived from the dropdown on the secretary page using the getParameter() method
     * <br>
     * Next, a patient is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the patient that matches the ID retrived. If an patient is found, it is then approved and serialized.
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
            String patID = request.getParameter("patientDrop");
            Patient pt = new Patient();
            
            ArrayList<Patient> tempStore = pt.deserialize();
            
            for(int i = 0; i < tempStore.size(); i++)
            {
                if(tempStore.get(i).getPatientID().equals(patID))
                {
                    tempStore.get(i).setPatientAccountStatus(true);
                    tempStore.get(i).serialize();
                }
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(approvePatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("secretaryPanel.jsp");
    }
}
