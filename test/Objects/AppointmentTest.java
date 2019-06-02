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
public class AppointmentTest {
    
    public AppointmentTest() {
    }
    /**
     * Test of getAppointmentID method, of class Appointment.
     */
    @Test
    public void testGetAppointmentID() {
        Appointment instance = new Appointment();
        String expResult = "P2712";
        instance.setAppointmentID(expResult);
        String result = instance.getAppointmentID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAppointmentID method, of class Appointment.
     */
    @Test
    public void testSetAppointmentID() {
        String expected = "P2712";
        Appointment instance = new Appointment();
        
        instance.setAppointmentID(expected);
        String actual = instance.getAppointmentID();
        assertTrue(actual.equals(expected));
    }
    /**
     * Test of getAppointmentApproved method, of class Appointment.
     */
    @Test
    public void testGetAppointmentApproved() {
        Appointment instance = new Appointment();
        instance.setAppointmentApproved(true);
        Boolean expected = true;
        Boolean result = instance.getAppointmentApproved();
        assertEquals(expected, result);
    }

    /**
     * Test of setAppointmentApproved method, of class Appointment.
     */
    @Test
    public void testSetAppointmentApproved() {
        System.out.println("setAppointmentApproved");
        Boolean appointmentApproved = null;
        Appointment instance = new Appointment();
        instance.setAppointmentApproved(appointmentApproved);
    }
    
}
