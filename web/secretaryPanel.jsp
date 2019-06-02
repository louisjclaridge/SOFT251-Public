<%-- 
    Document   : secretaryPanel
    Created on : 12-Jan-2019, 20:14:28
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
        session.setAttribute("page", "secretary");    
        Patient patient = new Patient();      
        ArrayList<Patient> storePat = patient.deserialize();
        Appointment appointment = new Appointment();
        ArrayList<Appointment> storeApp = appointment.deserialize();
        Doctor doctor = new Doctor();
        ArrayList<Doctor> storeDoc = doctor.deserialize();
        Secretary sec = new Secretary();
        ArrayList<Secretary> storeSec = sec.deserialize();
        Medicine med = new Medicine();
        ArrayList<Medicine> storeMed = med.deserialize();
         %>
    </head>
    <body>
        <button style="float: right"><a href="login.jsp">Logout</a></button>
        <h1>Secretary Panel</h1>
        <h1>Hello, <%= session.getAttribute("userID").toString()%></h1>
        <h2>Approve Patients</h2>
                <form action="approvePatient">       
            <select name="patientDrop">
        <%
            for(int i = 0; i < storePat.size(); i++)
            {
                if(storePat.get(i).getPatientAccountStatus().equals(false))
                {
                %>
                <option value="<%= storePat.get(i).getPatientID() %>"><%= storePat.get(i).getPatientID() %></option> 
          <% }
            }
      %>
           </select>
           <input value="Approve" type="submit"/>
        </form>
           <h2>Approve patient removals</h2>
        <form action="removeAccounts">
            <select name="patDrop">
        <%
        storePat = patient.deserialize();
        if(storePat.isEmpty() == false)
        {
            for(int i = 0; i < storePat.size(); i++)
            {
                if(storePat.get(i).getPatientRequestedTermination().equals(true))
                {
                %>
                <option value="<%= storePat.get(i).getPatientID() %>"><%= storePat.get(i).getPatientID() %></option> 
          <% }

          } 
}%>
           </select>
<input type="submit" onabort="" value="Remove"/>
        </form>
           <h2>Approve appointments</h2>
        <form action="approveAppointments">
            <select name="appApproveDrop">
        <%
            for(int i = 0; i < storeApp.size(); i++)
            {
            if(storeApp.get(i).getAppointmentApproved().equals(false))
            {   %>
            <option value="<%= storeApp.get(i).getAppointmentID() %>">Patient : <%= storeApp.get(i).getAppointmentPatient().getPatientFullName() %> Doctor: <%= storeApp.get(i).getAppointmentDoctor().getDoctorFullName() %> Date: <%= storeApp.get(i).getAppointmentDate() %> </option> 
          <% }
            }%>
           </select>
           <input type="submit" name="approve" value="Approve"/>
           <input type="submit" name="reject" value="Reject"/>   
        </form>
        <h2>Create an Appointment</h2>
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
           <br>
                       <label>Patient</label>
            <br>
        <select name="patDrop">
        <%
            for(int i = 0; i < storePat.size(); i++)
            {
                %>
                <option value="<%= storePat.get(i).getPatientID()%>"><%= storePat.get(i).getPatientFullName() %></option> 
          <% }%>
           </select>             
               <br>
               <input type="submit"/>
        </form>
           <h2>Your notifications</h2>
               <table style="border: 1px solid black">
            <th>Message</th>                   
                <%
            for(int i = 0; i < storeSec.size(); i++)
            {
               for(int x = 0; x < storeSec.get(i).getSecretaryNotifications().size(); x++)
                {
                %>
            <tr style="border: 1px solid black">
                <td style="border: 1px solid black"><%= storeSec.get(i).getSecretaryNotifications().get(x)%></td>                          
            </tr>
                
      <% }
                }%>
        </table>
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
                  <h2>Stock Medicine</h2>    
                    <form action="stockMedicine">
                    <select name="medDrop">
                    <%
                    for(int i = 0; i < storeMed.size(); i++)
                    {
                    %>
                    <option value="<%= storeMed.get(i).getMedicineID() %>"><%= storeMed.get(i).getMedicineName() + " " + storeMed.get(i).getMedicineQuantityInStock().toString() %></option> 
                    <% }%>
                    </select>      
                    <br>
                    <label>Amount to stock</label>
                    <br>
                    <input name="medToStock" type="number" min="0"/>
                    <br>
                    <input type="submit"/>
                    </form>
    </body>
</html>
