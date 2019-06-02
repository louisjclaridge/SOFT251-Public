<%-- 
    Document   : adminPanel
    Created on : 16-Jan-2019, 20:26:48
    Author     : louis
--%>
<%@page import="java.util.*"%>
<%@page import="Users.*"%>
<%@page import="Serverlets.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
              session.setAttribute("page", "admin");    
        %>
    </head>
    <body>
        <button style="float: right"><a href="login.jsp">Logout</a></button>        
        <h1>Remove Accounts</h1>
        <form action="removeAccounts">
            <label>Doctor</label>
            <br>
            <select name="doctorDrop">
        <%
        Doctor doctor = new Doctor();      
        ArrayList<Doctor> storeDoc = new ArrayList();
        storeDoc = doctor.deserialize();
            for(int i = 0; i < storeDoc.size(); i++)
            {
                %>
                <option value="<%= storeDoc.get(i).getDoctorID() %>"><%= storeDoc.get(i).getDoctorID() %></option> 
      <% } %>
           </select>
        <input type="submit" value="Remove"/>
        </form>
      <br><br>
      <form action="removeAccounts">  
            <label>Secretary</label>
            <br>
            <select name="secDrop">
        <%
        Secretary secretary = new Secretary();
        ArrayList<Secretary> storeSec = new ArrayList();
        storeSec = secretary.deserialize();
            for(int i = 0; i < storeSec.size(); i++)
            {
                %>
                <option value="<%= storeSec.get(i).getSecretaryID()%>"><%= storeSec.get(i).getSecretaryID() %></option> 
      <% } %>
    </select>
    <input type="submit" value="Remove"/>
        </form>
    <br><br>
    <table style="border: 1px solid black">
            <th>Doctor ID</th>
            <th>Doctor rating </th>
                <%
            for(int i = 0; i < storeDoc.size(); i++)
            {
                %>
            <tr style="border: 1px solid black">
            <td style="border: 1px solid black"><%= storeDoc.get(i).getDoctorID()%></td>
            <td style="border: 1px solid black"><%= storeDoc.get(i).getDoctorRating().toString()%></td>
            </tr>
                
      <% } %>
        </table>
        <br>
            <label>Doctor</label>
            <br>        
        <form action="<%session.setAttribute("page", "admin"); %>
              feedback">       
            <select name="feedbackDrop">
        <%
        Doctor dr = new Doctor();      
        ArrayList<Doctor> strDoc = new ArrayList();
        strDoc = dr.deserialize();
            for(int i = 0; i < strDoc.size(); i++)
            {
                %>
                <option value="<%= strDoc.get(i).getDoctorID() %>"><%= strDoc.get(i).getDoctorID() %></option> 
      <% }

              
      
      %>
           </select>
           <br>
            <label>Message</label>
            <br>       
           <textarea name="feedback"></textarea>
           <br>
        <input type="submit" value="Submit Feedback"/>
        </form>
    </body>
</html>
