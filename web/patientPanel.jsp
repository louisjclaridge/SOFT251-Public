<%-- 
    Document   : patientPanel
    Created on : 12-Jan-2019, 17:19:44
    Author     : louis
--%>
<%@page import="java.util.*"%>
<%@page import="Users.*"%>
<%@page import="Objects.*"%>
<%@page import="Serverlets.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
         Doctor doctor = new Doctor();
         Patient patient = new Patient();
         Appointment appointment = new Appointment();
         Prescription prescription = new Prescription();
         
         ArrayList<Doctor> storeDoc = doctor.deserialize();
         ArrayList<Patient> storePat = patient.deserialize();
         ArrayList<Appointment> storeApp = appointment.deserialize();
         ArrayList<Prescription> storePrescriptions = prescription.deserialize();
         %>
    </head>
    <body>
        <button style="float: right"><a href="login.jsp">Logout</a></button>
        <h1>Patient Panel</h1>
        <h2>Rate a doctor</h2>
               <table style="border: 1px solid black">
            <th>Doctor name</th>                   
            <th>Doctor rating </th>
                <%
            for(int i = 0; i < storeDoc.size(); i++)
            {
                %>
            <tr style="border: 1px solid black">
             <td style="border: 1px solid black"><%= storeDoc.get(i).getDoctorFirstName() + " "  +  storeDoc.get(i).getDoctorLastName() %></td>                
            <td style="border: 1px solid black"><%= storeDoc.get(i).getDoctorRating().toString()%></td>
            </tr>
                
      <% } %>
        </table>
                <br>
             
        <form action="<%session.setAttribute("page", "patient"); %>
              feedback"> 
            <label>Doctor</label>
            <br>
            <select name="feedbackDrop">
        <%
            for(int i = 0; i < storeDoc.size(); i++)
            {
                %>
                <option value="<%= storeDoc.get(i).getDoctorID() %>"><%= storeDoc.get(i).getDoctorFirstName() + " "  +  storeDoc.get(i).getDoctorLastName() %></option> 
      <% }%>
           </select>
           <br>
           <label>Rating (0-10)</label>
           <br>
            <input name="rating" type="number" min="1" max="10" value="1"></input>
            <br>
           <label>Feedback message</label>
           <br>
           <textarea name="feedback"></textarea>
           <br>
           <input type="submit" value="Submit Feedback"/>
        </form>
                <h2>Your prescriptions</h2>
                <table style="border: 1px solid black">
                <th>Medicine</th>                   
                <th>Dosage</th>
                <th>Prescribed by</th>
                <%
                for(int i = 0; i < storePrescriptions.size(); i++)
                {
                    if(storePrescriptions.get(i).getPrescriptionPatient().getPatientID().equals(session.getAttribute("userID")))
                    {
                %>
                <tr>
                <td style="border: 1px solid black"><%= storePrescriptions.get(i).getPrescriptionMedicine().getMedicineName() %></tdr>
                <td style="border: 1px solid black"><%= storePrescriptions.get(i).getPrescriptionMedicine().getMedicineDosage() %></td>                
                <td style="border: 1px solid black"><%= storePrescriptions.get(i).getPrescriptionDoctor().getDoctorFullName()%></td>
                </tr>

                <% }
                } %>
                </table>   
           <h2>Request an appointment</h2>
          <form action="requestAppointment">
            <label>Date</label>
            <br>
            <input name="date" type="date"/>
            <br>
            <label>Doctor</label>
            <br>
        <select name="docDrop">
        <%
            for(int i = 0; i < storeDoc.size(); i++)
            {
                %>
                <option value="<%= storeDoc.get(i).getDoctorID() %>"><%= storeDoc.get(i).getDoctorFirstName() + " " + storeDoc.get(i).getDoctorLastName() %></option> 
          <% }%>
           </select>  
               <br><br>
               <input type="submit"/>
        </form>
           <br>
           <h2>Your Appointments</h2>
               <table style="border: 1px solid black">
            <th>Doctor name</th>                   
            <th>Date of Appointment</th>
                <%
            for(int i = 0; i < storeApp.size(); i++)
            {
                if(storeApp.get(i).getAppointmentPatient().getPatientID().equals(session.getAttribute("userID")) && storeApp.get(i).getAppointmentApproved().equals(true))
                {
                %>
            <tr style="border: 1px solid black">
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentDoctor().getDoctorFirstName() + " "  +  storeApp.get(i).getAppointmentDoctor().getDoctorLastName() %></td>                
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentDate() %></td>
            </tr>
                
      <% }
                }%>
        </table>
           <br>
           <h2>Past Appointments</h2>
               <table style="border: 1px solid black">
            <th>Doctor name</th>                   
            <th>Date of Appointment</th>
                <%
                    ArrayList<Appointment>  storePastApps = appointment.getPastAppointments(session.getAttribute("userID").toString());
            for(int i = 0; i < storePastApps.size(); i++)
            {
                if(storeApp.get(i).getAppointmentApproved().equals(true))
                {
                %>
            <tr style="border: 1px solid black">
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentDoctor().getDoctorFirstName() + " "  +  storeApp.get(i).getAppointmentDoctor().getDoctorLastName() %></td>                
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentDate() %></td>
            </tr>
                
      <% }
                }%>
        </table>        
           <h2>Request Termination</h2>
        <form action="requestTermination">
            <input value="Request Termination" type="submit"/>
        </form>
    </body>
</html>
