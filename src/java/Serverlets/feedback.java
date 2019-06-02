/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serverlets;

import Objects.Feedback;
import Users.Doctor;
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

/**
 *
 * @author louis
 */
@WebServlet(name = "feedback", urlPatterns = {"/feedback"})
public class feedback extends HttpServlet {

    /**
     *feedback serverlet, this is used to give feedback to a given doctor
     * <br><br>
     * First, all relevant attributes are retrieved from the page using the getParameter() method.
     * <br>
     * Next, a doctor is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the doctor that matches the ID retrived. If an doctor is found, a feedback object is generated, the doctor and feedback is added and then it is serialized.
     * <br><br>
     * The next section deals with Rating a doctor
     * <br><br>
     * First, the "page" attribute is generated from the session variable generated on the previous page.
     * <br>
     * Next, a check is made to see what the "page" variable has stored. If its an admin, they are redirected back as they do not give ratings
     * <br>
     * If the page originating the request is a patient, a rating is retrived from the patientPanel by using the getParameter(), a doctor ID is also retrived in this way
     * <br>
     * Next, a doctor is created to access the deserialize() method and an arraylist created based on the output from that method
     * <br>
     * Next, a for loop is used to itterate through the arraylist to find the doctor that matches the ID retrived. If an doctor is found, the setDoctorRating() method is called, passing through the rating.
     * <br>
     * Finally, the doctor is serialized and the patient is re-directed back to their panel
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
                String feedbackMessage = request.getParameter("feedback");
                String feedbackDoctor = request.getParameter("feedbackDrop");
                Doctor dr = new Doctor();
                ArrayList<Doctor> tempStore = dr.deserialize();
                
                for(int i = 0; i < tempStore.size(); i++)
                {
                    if(tempStore.get(i).getDoctorID().equals(feedbackDoctor))
                    {
                        Feedback feedback = new Feedback(tempStore.get(i), feedbackMessage);
                        feedback.serialize();
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(feedback.class.getName()).log(Level.SEVERE, null, ex);
            }
            String pa = request.getSession().getAttribute("page").toString();
            if(pa.equals("admin"))
            {
                response.sendRedirect("adminPanel.jsp");
            }
            if(pa.equals("patient"))
            {
            try {
            Double newRating = Double.parseDouble(request.getParameter("rating"));
            String feedbackDoctor = request.getParameter("feedbackDrop");
            Doctor dr = new Doctor();
            ArrayList<Doctor> tempStore = dr.deserialize();
            
            for(int i = 0; i < tempStore.size(); i++)
            {
                if(tempStore.get(i).getDoctorID().equals(feedbackDoctor))
                {
                    tempStore.get(i).setDoctorRating(newRating);
                    tempStore.get(i).serialize();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(feedback.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("patientPanel.jsp");
            }
            else
            {
                System.out.println("no page to refer back to");
            }
    }
}
