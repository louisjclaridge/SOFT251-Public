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
public class AdministratorTest {
    
    public AdministratorTest() {
    }
    /**
     * Test of getAdministratorFirstName method, of class Administrator.
     */
    @Test
    public void testGetAdministratorFirstName() {
        Administrator instance = new Administrator();
        String expected = "expected outcome";
        instance.setAdministratorFirstName(expected);
        String result = instance.getAdministratorFirstName();
        assertEquals(expected, result);
    }

    /**
     * Test of setAdministratorFirstName method, of class Administrator.
     */
    @Test
    public void testSetAdministratorFirstName() {
        Administrator instance = new Administrator();
        String expected = "expected outcome";
        instance.setAdministratorFirstName(expected);
        String result = instance.getAdministratorFirstName();
        assertEquals(expected, result);
    }
}
