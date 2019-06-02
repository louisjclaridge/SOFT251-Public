/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Users.Doctor;
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
public class FeedbackTest {
    
    public FeedbackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of getFeedbackMessage method, of class Feedback.
     */
    @Test
    public void testGetFeedbackMessage() {
        Doctor doctor = new Doctor();
        Feedback instance = new Feedback(doctor, "expected result");
        String expResult = "expected result";
        String result = instance.getFeedbackMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setFeedbackMessage method, of class Feedback.
     */
    @Test
    public void testSetFeedbackMessage() {
        Doctor doctor = new Doctor();
        Feedback instance = new Feedback();
        String expectedOutcome = "expected outcome";
        instance.setFeedbackMessage(expectedOutcome);
        
        String actualOutcome = instance.getFeedbackMessage();
        assertTrue(actualOutcome.equals(expectedOutcome));
    }
    
}
