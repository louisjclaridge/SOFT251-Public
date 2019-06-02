/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

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
public class PatientTest {
    
    public PatientTest() {
    }
    /**
     * Test of getPatientAge method, of class Patient.
     */
    @Test
    public void testGetPatientAge() 
    {
        Patient patient = new Patient();
        patient.setPatientDateOfBirth("1998-04-26");
        
        Integer expected = 20;
        Integer actual = patient.getPatientAge();
        
        assertTrue(expected.equals(actual));
    }

    /**
     * Test of getPatientFirstName method, of class Patient.
     */
    @Test
    public void testGetPatientFirstName() {
        Patient instance = new Patient();
        String expected = "expected result";
        instance.setPatientFirstName(expected);
        String result = instance.getPatientFirstName();
        assertEquals(expected, result);
    }

    /**
     * Test of setPatientFirstName method, of class Patient.
     */
    @Test
    public void testSetPatientFirstName() {
        Patient instance = new Patient();
        String expected = "expected result";
        instance.setPatientFirstName(expected);
        String result = instance.getPatientFirstName();
        assertEquals(expected, result);
    }

    /**
     * Test of getPatientRequestedTermination method, of class Patient.
     */
    @Test
    public void testGetPatientRequestedTermination() {
        Patient instance = new Patient();
        Boolean expected = true;
        instance.setPatientRequestedTermination(expected);
        Boolean result = instance.getPatientRequestedTermination();
        assertEquals(expected, result);
    }

    /**
     * Test of setPatientRequestedTermination method, of class Patient.
     */
    @Test
    public void testSetPatientRequestedTermination() {
        Patient instance = new Patient();
        Boolean expected = true;
        instance.setPatientRequestedTermination(expected);
        Boolean result = instance.getPatientRequestedTermination();
        assertEquals(expected, result);
    }    
}
