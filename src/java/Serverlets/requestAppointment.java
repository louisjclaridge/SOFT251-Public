/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Objects.*;
import Users.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
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
@WebServlet(name = "requestAppointment", urlPatterns = {"/requestAppointment"})
public class requestAppointment extends HttpServlet {

    /**
     *requestAppointment serverlet, this is used to request appointments, this is used by doctors and patients
     * <br><br>
     * First, all relevant attributes are retrieved from the page using the getParameter() method.
     * <br>
     * Next, a check is made to determine what the first letter of the ID is, this is to make sure that the correct item varriables are defined.
     * <br>
     * Next, a doctor and patient are created to make use of their deserialize() methods, arraylists are then generated from the output from these methods
     * <br>
     * Next, the arrays are itterated through to get the correct doctor and patient
     * <br>
     * Finally, based on the first letter of the User ID, the correct appointment object is created and serialized
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
        try {
            String appID = UUID.randomUUID().toString();
            String notes = "";
            String userID = session.getAttribute("userID").toString();
            String appDate = request.getParameter("date");
            String patID = "";
            String docID = "";
            
            if(userID.substring(0, 1).contains("P") )
            {
                patID = session.getAttribute("userID").toString();
                docID = request.getParameter("docDrop");
            }
            if(userID.substring(0, 1).contains("D") )
            {
                docID = session.getAttribute("userID").toString();
                patID = request.getParameter("patDrop");
            }            
            if(userID.substring(0, 1).contains("S") )
            {
                docID = request.getParameter("docDrop");
                patID = request.getParameter("patDrop");
            }
            
            Doctor doc = new Doctor();
            Patient pat = new Patient();
            ArrayList<Doctor> docStore = doc.deserialize();
            ArrayList<Patient> patStore = pat.deserialize();
            
            for(int i = 0; i < docStore.size(); i++)
            {
                if(docStore.get(i).getDoctorID().equals(docID))
                {
                    doc = docStore.get(i);
                }
            }
            
            for(int i = 0; i < patStore.size(); i++)
            {
                if(patStore.get(i).getPatientID().equals(patID))
                {
                   pat = patStore.get(i);
                }
            }
            if(userID.substring(0, 1).contains("P"))
            {
                Appointment appointment = new Appointment(appID, appDate, pat, doc, notes, false);  
                response.sendRedirect("patientPanel.jsp");
                appointment.serialize();                
            }
            if(userID.substring(0, 1).contains("D"))
            {
                Appointment appointment = new Appointment(appID, appDate, pat, doc, notes, false);  
                response.sendRedirect("doctorPanel.jsp");
                appointment.serialize();
            }
            else if(userID.substring(0, 1).contains("S"))
            {
                Appointment appointment = new Appointment(appID, appDate, pat, doc, notes, true);
                response.sendRedirect("secretaryPanel.jsp");
                appointment.serialize();
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(requestAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
