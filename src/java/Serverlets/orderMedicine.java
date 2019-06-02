/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import java.io.IOException;
import java.io.PrintWriter;
import Objects.*;
import Users.*;
import ObserverPattern.Observer;
import java.io.FileNotFoundException;
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
@WebServlet(name = "orderMedicine", urlPatterns = {"/orderMedicine"})
public class orderMedicine extends HttpServlet {
    
    /**
     *orderMedicine serverlet, this is used to create medicine, register observers and notify observers
     * <br><br>
     * First, all relevant attributes are retrieved from the page using the getParameter() method.
     * <br>
     * Next, a medicine is created using the captured varriables.
     * <br>
     * Next, a secretary is created to make use of its deserialize() method, an arraylist is created from the output.
     * <br>
     * Next, the array is ittereated through. A check is made to see if a secretary already exists within the array. If not, it is added.
     * <br>
     * Next, the secretary is registered as a observer of the medicine.
     * <br>
     * Next, the medicine is serialized and the observers are notified.
     * <br>
     * Finally, the user is returned to the appropriate page/
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
            String medID = UUID.randomUUID().toString();
            String medName = request.getParameter("medName");
            String medDose = request.getParameter("medDose");
            ArrayList<Secretary> array = new ArrayList<Secretary>();
            Medicine med = new Medicine(medID, medName, 0, medDose, array);
            
            Secretary sec = new Secretary();
            ArrayList<Secretary> secArray = sec.deserialize();
            
            for(int i = 0; i < secArray.size(); i++ )
            {
                med.registerObserver(secArray.get(i));                    
            } 
            med.notifyObservers();
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderMedicine.class.getName()).log(Level.SEVERE, null, ex);
        }
        String userID = session.getAttribute("userID").toString();
        if(userID.substring(0,1).contains("D"))
        {
          response.sendRedirect("doctorPanel.jsp");
        }
        if(userID.substring(0,1).contains("S"))
        {
          response.sendRedirect("secretaryPanel.jsp");
        }        
    }
}
