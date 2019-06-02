/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Objects.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author louis
 */
@WebServlet(name = "stockMedicine", urlPatterns = {"/stockMedicine"})
public class stockMedicine extends HttpServlet {

    /**
     *stockMedicine serverlet, this is used to add stock to a given medicine
     * <br><br>
     * First, all relevant attributes are retrieved from the page using the getParameter() method.
     * <br>
     * Next, a medicine is created to access the deserialize() method and an arraylist is created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the medicine that matches the ID retrived. If a medicine is found, the quantity is updated with the amount retrived
     * <br>
     * Finally, the object is serialized and the secretary is redirected to their panel.
     * @param request - gets request information from previous page
     * @param response - gets response information from previous page
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Integer amountToStock = Integer.parseInt(request.getParameter("medToStock"));
        String medID = request.getParameter("medDrop");
        
        Medicine med = new Medicine();
        ArrayList<Medicine> medStore = med.deserialize();
        for(int i = 0; i < medStore.size(); i++)
        {
            if(medStore.get(i).getMedicineID().equals(medID))
            {
                medStore.get(i).setMedicineQuantityInStock(amountToStock);
                medStore.get(i).serialize();
            }
        }
        
        response.sendRedirect("secretaryPanel.jsp");
    }
}
