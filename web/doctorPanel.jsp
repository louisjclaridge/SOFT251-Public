<%-- 
    Document   : doctorPanel
    Created on : 13-Jan-2019, 18:37:26
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
         
         ArrayList<Doctor> storeDoc = doctor.deserialize();
         ArrayList<Patient> storePat = patient.deserialize();
         ArrayList<Appointment> storeApp = appointment.deserialize();
        Medicine med = new Medicine();
        ArrayList<Medicine> storeMed = med.deserialize();
         %>        
    </head>
    <body>
        <button style="float: right"><a href="login.jsp">Logout</a></button>
        <h1>Doctor panel</h1>
        <h1>Welcome, <%= session.getAttribute("userID").toString()%></h1>
        <h2>Your appointments</h2>
               <table style="border: 1px solid black">
            <th>Patient Name</th>                   
            <th>Date of Appointment</th>
            <th>Appointment Notes</th>
                <%
            for(int i = 0; i < storeApp.size(); i++)
            {
                if(storeApp.get(i).getAppointmentDoctor().getDoctorID().equals(session.getAttribute("userID")) && storeApp.get(i).getAppointmentApproved().equals(true))
                {
                %>
            <tr style="border: 1px solid black">
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentPatient().getPatientFullName() %></td>                
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentDate() %></td>
                <td style="border: 1px solid black"><%= storeApp.get(i).getAppointmentNotes()%></td>                
            </tr>
                
      <% }
                }%>
        </table>
        <h2>View a specific patients history</h2>
        <form>
                    <select name="patHistoryDrop">
            <%
                for(int i = 0; i < storePat.size(); i++)
                {
                    %>
                    <option value="<%= storePat.get(i).getPatientID()%>">Patient: <%= storePat.get(i).getPatientFullName()%></option> 
              <% }%>
               </select>
               <button type="submit">Refresh</button>
               <br>
               <table style="border: 1px solid black">
            <th>Patient Name</th>                   
            <th>Date of Appointment</th>
            <th>Appointment Notes</th>
                <%
                    ArrayList<Appointment>  storePastApps = appointment.getPastAppointments(request.getParameter("patHistoryDrop"));                    
            for(int i = 0; i < storePastApps.size(); i++)
            {
                %>
            <tr style="border: 1px solid black">
                <td style="border: 1px solid black"><%= storePastApps.get(i).getAppointmentPatient().getPatientFullName() %></td>                
                <td style="border: 1px solid black"><%= storePastApps.get(i).getAppointmentDate() %></td>
                <td style="border: 1px solid black"><%= storePastApps.get(i).getAppointmentNotes()%></td>                
            </tr>
                
      <%  }%>
        </table>
        </form>        
        <br>
        <h2>Propose a appointment</h2>
        <form action="requestAppointment">
            <label>Patient</label>
            <br>
        <select name="patDrop">
        <%
            for(int i = 0; i < storePat.size(); i++)
            {
                %>
                <option value="<%= storePat.get(i).getPatientID() %>"><%= storePat.get(i).getPatientFullName() %></option> 
          <% }%>
           </select>  
           <br>
           <label>Date</label>
           <br>
           <input name="date" type="date"/>
               <br><br>
               <input type="submit"/>
        </form>
           <br>
           <h2>Order Medicine</h2>
           <form action="orderMedicine">
               <label>Medicine Name</label>
               <br>
               <input name="medName" type="text"/>
               <br>
               <label>Medicine Maximum Dosage</label>
               <br>
               <input name="medDose" type="text"/>
               <br>
               <input type="submit"/>
           </form>           
        <br>
        <h2>Make notes on an appointment</h2>
        <form action="makeAppointmentNotes">
            <select name="appDrop">
            <%
                for(int i = 0; i < storeApp.size(); i++)
                {
                    %>
                    <option value="<%= storeApp.get(i).getAppointmentID()%>">Patient: <%=storeApp.get(i).getAppointmentPatient().getPatientFullName()%> Date: <%= storeApp.get(i).getAppointmentDate()%></option> 
              <% }%>
               </select>
               <br>
               <textarea name="appNotes"></textarea>
               <br>
               <input type="submit"/>
        </form>
        <br>
        <h2>Create prescription</h2>               
        <form action="createPrescription">
            <label>Patient</label>
            <br>
            <select name="prescriptionPatientDrop">
            <%
                for(int i = 0; i < storePat.size(); i++)
                {
                    %>
                    <option value="<%= storePat.get(i).getPatientID()%>">Patient: <%= storePat.get(i).getPatientFullName()%></option> 
              <% }%>
               </select>
               <br>
             <label>Medicine</label>
            <br>
            <select name="prescriptionMedDrop">
            <%
                for(int i = 0; i < storeMed.size(); i++)
                {
                    %>
                    <option value="<%= storeMed.get(i).getMedicineID()%>">Medicine: <%= storeMed.get(i).getMedicineName() + " Max Dosage: " + storeMed.get(i).getMedicineDosage()%></option> 
              <% }%>
               </select>               
               <br>
               <label>Notes</label>
               <br>
               <textarea name="prescriptionNotes"></textarea>
               <br>
               <label>Amount</label>
               <br>
               <input name="prescriptionAmount"/>
               <br>
               <input type="submit"/>
        </form>               
    </body>
</html>
