/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Users.Secretary;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author louis
 */
public class MedicineTest {
    
    public MedicineTest() {
    }
    /**
     * Test of registerObserver method, of class Medicine.
     */    
    @Test
    public void testRemoveObserver()
    {
        Medicine instance = new Medicine();
        Secretary toAdd = new Secretary();
        toAdd.setSecretaryID("S123");
        
        instance.registerObserver(toAdd);
        instance.removeObserver(toAdd);
        
        assertTrue(instance.getMedObservers().isEmpty());
    }
    /**
     * Test of removeObserver method, of class Medicine.
     */    
    @Test
    public void testRegisterObserver()
    {
        Medicine instance = new Medicine();
        Secretary toAdd = new Secretary();
        
        instance.registerObserver(toAdd);
        
        assertTrue(instance.getMedObservers().size() == 1);
    }
    /**
     * Test of removeObserver method, of class Medicine.
     */    
    @Test
    public void testNotifyObserver()
    {
        ArrayList<Secretary> observerList = new ArrayList();
        ArrayList<String> notificationList = new ArrayList();
        Medicine instance = new Medicine("ID", "Name", 0, "Dosage", observerList );
        Secretary toAdd = new Secretary();
        toAdd.setSecretaryNotifications(notificationList);
        instance.registerObserver(toAdd);
        instance.notifyObservers();
        
        assertTrue(toAdd.getSecretaryNotifications().size() == 1);
    }       
    /**
     * Test of takeMedicine method, of class Medicine.
     */
    @Test
    public void testTakeMedicine() {
        Integer amountToRemove = 5;
        ArrayList<Secretary> observer = new ArrayList();
        Medicine instance = new Medicine("ID", "Name", 10, "Dosage", observer);
        instance.takeMedicine(amountToRemove);
        Integer expected = 5;
        Integer actual = instance.getMedicineQuantityInStock();
        assertTrue(expected.equals(actual));
    }
    /**
     * Test of setMedicineQuantityInStock method, of class Medicine.
     */
    @Test
    public void testSetMedicineQuantityInStock() {
        ArrayList<Secretary> observer = new ArrayList();        
        Integer medicineQuantityInStock = 10;
        Medicine instance = new Medicine("ID", "Name", 10, "Dosage", observer);
        instance.setMedicineQuantityInStock(medicineQuantityInStock);
        
        Integer expected = 20;
        Integer actual = instance.getMedicineQuantityInStock();
        
        assertTrue(expected.equals(actual));
    }
    @Test
    public void testGetMedicineQuantityInStock() { 
        ArrayList<Secretary> observer = new ArrayList();              
        Integer expected = 10;
        Medicine instance = new Medicine("ID", "Name", 10, "Dosage", observer);
        
        Integer actual = instance.getMedicineQuantityInStock();
        
        assertTrue(expected.equals(actual));
    }    
    
}
