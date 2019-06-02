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
public class DoctorTest {
    
    public DoctorTest() {
    }

    /**
     * Test of getDoctorFirstName method, of class Doctor.
     */
    @Test
    public void testGetDoctorFirstName() {
        Doctor instance = new Doctor();
        String expected = "expectedOutcome";
        instance.setDoctorFirstName(expected);
        String actual = instance.getDoctorFirstName();
        assertEquals(expected, actual);
    }

    /**
     * Test of setDoctorFirstName method, of class Doctor.
     */
    @Test
    public void testSetDoctorFirstName() {
        Doctor instance = new Doctor();
        String expected = "expectedOutcome";
        instance.setDoctorFirstName(expected);
        String actual = instance.getDoctorFirstName();
        assertEquals(expected, actual);
    }

    /**
     * Test of getDoctorLastName method, of class Doctor.
     */
    @Test
    public void testGetDoctorLastName() {
        Doctor instance = new Doctor();
        String expected = "expectedOutcome";
        instance.setDoctorLastName(expected);
        String actual = instance.getDoctorLastName();
        assertEquals(expected, actual);
    }
        /**
     * Test of setDoctorLastName method, of class Doctor.
     */
    @Test
    public void testSetDoctorLastName() {
        Doctor instance = new Doctor();
        String expected = "expectedOutcome";
        instance.setDoctorLastName(expected);
        String actual = instance.getDoctorLastName();
        assertEquals(expected, actual);
    }
    /**
     * Test of getDoctorRating method, of class Doctor.
     */
    @Test
    public void testGetDoctorRating() {
        Doctor instance = new Doctor("Firstname", "Lastname", "Address", "Gender", "Date of Birth", "ID", "Password", 0.0);
        Double expected = 1.0;
        instance.setDoctorRating(1.0);
        Double actual = instance.getDoctorRating();
        assertEquals(expected, actual);
    }

    /**
     * Test of setDoctorRating method, of class Doctor.
     */
    @Test
    public void testSetDoctorRating() {
        Doctor instance = new Doctor("Firstname", "Lastname", "Address", "Gender", "Date of Birth", "ID", "Password", 0.0);
        Double expected = 1.0;
        instance.setDoctorRating(1.0);
        Double actual = instance.getDoctorRating();
        assertEquals(expected, actual);
    }

    /**
     * Test of getDoctorFullName method, of class Doctor.
     */
    @Test
    public void testGetDoctorFullName() {
        Doctor instance = new Doctor();
        String expResult = "John Smith";
        instance.setDoctorFirstName("John");
        instance.setDoctorLastName("Smith");
        String result = instance.getDoctorFullName();
        assertEquals(expResult, result);
    }
    
}
