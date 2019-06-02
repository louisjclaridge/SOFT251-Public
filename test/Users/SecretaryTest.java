/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Objects.Medicine;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author louis
 */
public class SecretaryTest {
    
    public SecretaryTest() {
    }

    /**
     * Test of getSecretaryFirstName method, of class Secretary.
     */
    @Test
    public void testGetSecretaryFirstName() {
        String expected = "expected outcome";
        Secretary instance = new Secretary();
        instance.setSecretaryFirstName(expected);
        String actual = instance.getSecretaryFirstName();
        
        assertTrue(actual.equals(expected));
    }

    /**
     * Test of setSecretaryFirstName method, of class Secretary.
     */
    @Test
    public void testSetSecretaryFirstName() {
        String expected = "expected outcome";
        Secretary instance = new Secretary();
        instance.setSecretaryFirstName(expected);
        String actual = instance.getSecretaryFirstName();
        
        assertTrue(actual.equals(expected));
    }

    /**
     * Test of getSecretaryNotifications method, of class Secretary.
     */
    @Test
    public void testGetSecretaryNotifications() {
        ArrayList<String> expected = new ArrayList();
        Secretary instance = new Secretary();
        expected.add("testing");
        instance.setSecretaryNotifications(expected);
        
        ArrayList<String> actual = instance.getSecretaryNotifications();
        
        assertTrue(actual.equals(actual));
    }

    /**
     * Test of setSecretaryNotifications method, of class Secretary.
     */
    @Test
    public void testSetSecretaryNotifications() {
        ArrayList<String> expected = new ArrayList();
        Secretary instance = new Secretary();
        expected.add("testing");
        instance.setSecretaryNotifications(expected);
        
        ArrayList<String> actual = instance.getSecretaryNotifications();
        
        assertTrue(actual.equals(actual));
    }    
    /**
     * Test of update method, of class Secretary.
     */
    @Test
    public void testUpdate() 
    {
        ArrayList<String> notificationList = new ArrayList();
        
        Secretary secInstance = new Secretary("Firstname", "Lastname", "Address", "Gender", "Date of Birth", "ID", "Password", notificationList);
        String toAdd = "Medicine" + " " + "Message";     
        ArrayList<String> toTest = secInstance.getSecretaryNotifications();
        toTest.add(toAdd);
        
        Integer expected = 1;
        Integer actual = toTest.size();

        assertTrue(expected.equals(actual));
    }       
}
