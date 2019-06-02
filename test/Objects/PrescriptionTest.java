/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Users.Doctor;
import Users.Patient;
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
public class PrescriptionTest {
    
    public PrescriptionTest() {
    }
    /**
     * Test of getPresciptionNotes method, of class Prescription.
     */
    @Test
    public void testGetPresciptionNotes() {
        Prescription instance = new Prescription();
        String expected = "expected result";
        instance.setPresciptionNotes(expected);
        String result = instance.getPresciptionNotes();
        assertEquals(expected, result);
    }

    /**
     * Test of setPresciptionNotes method, of class Prescription.
     */
    @Test
    public void testSetPresciptionNotes() 
    {
        Prescription instance = new Prescription();
        String expected = "expected result";
        instance.setPresciptionNotes(expected);
        String result = instance.getPresciptionNotes();
        assertEquals(expected, result);
    }

    /**
     * Test of getPrescriptionAmount method, of class Prescription.
     */
    @Test
    public void testGetPrescriptionAmount() {
        Prescription instance = new Prescription();
        Integer expected = 10;
        instance.setPrescriptionAmount(expected);
        Integer result = instance.getPrescriptionAmount();
        assertEquals(expected, result);
    }

    /**
     * Test of setPrescriptionAmount method, of class Prescription.
     */
    @Test
    public void testSetPrescriptionAmount() {
        Prescription instance = new Prescription();
        Integer expected = 10;
        instance.setPrescriptionAmount(expected);
        Integer result = instance.getPrescriptionAmount();
        assertEquals(expected, result);
    }
    
}
