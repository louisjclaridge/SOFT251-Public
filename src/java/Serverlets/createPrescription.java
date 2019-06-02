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
     *createPrescription Serverlet, this is used to create a prescription based upon information inputed on the doctor panel
     * <br><br>
     * First, all relevant attributes are retrieved from the doctorPanel.jsp page using the getParameter() method.
     * <br>
     *Next, for loops are used to get correct patient, doctor and medicine
     * <br>
     * Next, a medicine object is created using the variables defined.
     * <br>
     * Finally, the object is serialized using the serialization method built into the object and the doctor is redirected to the doctor panel'
 * @author louis
 */
@WebServlet(name = "createPrescription", urlPatterns = {"/createPrescription"})
public class createPrescription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException 
    {
            HttpSession session = request.getSession();        
        try {
            Patient pat = new Patient();
            ArrayList<Patient>storePat = pat.deserialize();
            Doctor doc = new Doctor();
            ArrayList<Doctor> storeDoc = doc.deserialize();
            Medicine med = new Medicine();
            ArrayList<Medicine> storeMed = med.deserialize();
            
            String ID = UUID.randomUUID().toString();
            String patID = request.getParameter("prescriptionPatientDrop");
            String medID = request.getParameter("prescriptionMedDrop");
            String doctorID = session.getAttribute("userID").toString();
            String notes = request.getParameter("prescriptionNotes");
            Integer amount = Integer.parseInt(request.getParameter("prescriptionAmount"));
            
            for(int i = 0; i < storePat.size(); i++)
            {
                if(storePat.get(i).getPatientID().equals(patID))
                {
                    pat = storePat.get(i);
                }
            }
            for(int i = 0; i < storeDoc.size(); i++)
            {
                if(storeDoc.get(i).getDoctorID().equals(doctorID))
                {
                    doc = storeDoc.get(i);
                }
            }
            for(int i = 0; i < storeMed.size(); i++)
            {
                if(storeMed.get(i).getMedicineID().equals(medID))
                {
                    med = storeMed.get(i);
                    med.takeMedicine(amount);
                    med.serialize();
                }
            }                   
            
            
            Prescription prescription = new Prescription(ID, pat, doc, notes, med, amount);
            prescription.serialize();
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(createPrescription.class.getName()).log(Level.SEVERE, null, ex);
        }
            response.sendRedirect("doctorPanel.jsp");
    }
}
