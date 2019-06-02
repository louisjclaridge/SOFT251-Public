/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Users.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
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
@WebServlet(name = "removeAccounts", urlPatterns = {"/removeAccounts"})
public class removeAccounts extends HttpServlet {

    /**
     * removeAccounts serverlet, this is used to remove doctor, secretary, and patient accounts
     * <br><br>
     * First, a check is made to deterimine which dropdown is being used. This makes sure that items can be deleted accordingly.
     * <br>
     * Next, the contents of the relevent dropdown are reterived using the getParameter() method
     * <br>
     * Next, a user is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the user that matches the ID retrived. If an user is found, the user is removed using the remove() method.
     * <br>
     * Finally. the user is redirected back to their panel
     * @param request - gets request information from previous page
     * @param response - gets response information from previous page
     * @throws ServletException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InvalidClassException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException, InvalidClassException 
    {
        HttpSession session = request.getSession();
        if(request.getParameter("doctorDrop") != null)
        {
            try {
                String drop = request.getParameter("doctorDrop");
                Doctor dr = new Doctor();
                ArrayList<Doctor> tempStore = dr.deserialize();
                for(int i = 0; i < tempStore.size(); i++)
                {
                    if(tempStore.get(i).getDoctorID().equals(drop))
                    {
                        try {
                            dr.remove(tempStore.get(i).getDoctorID());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("adminPanel.jsp");
            
        }
            if(request.getParameter("secDrop") != null)
            {
            try {
                String dropDwn = request.getParameter("secDrop");
                Secretary sec = new Secretary();
                ArrayList<Secretary> tempSec = sec.deserialize();
                for(int i = 0; i < tempSec.size(); i++)
                {
                    if(tempSec.get(i).getSecretaryID().equals(dropDwn))
                    {
                        try {
                            sec.remove(tempSec.get(i).getSecretaryID());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
            }
           response.sendRedirect("adminPanel.jsp");
            }
        
        
        if(request.getParameter("patDrop") != null)
        {
            try {
                String dropDwn = request.getParameter("patDrop");
                Patient patient = new Patient();
                ArrayList<Patient> tempPat = patient.deserialize();
                for(int i = 0; i < tempPat.size(); i++)
                {
                    if(tempPat.get(i).getPatientID().equals(dropDwn))
                    {
                        try {
                            patient.remove(tempPat.get(i).getPatientID());
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(removeAccounts.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("secretaryPanel.jsp");
        }
    }
}
