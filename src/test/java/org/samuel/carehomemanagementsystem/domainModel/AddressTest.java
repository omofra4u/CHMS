package org.samuel.carehomemanagementsystem.domainModel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AddressTest extends BaseTest {
    
    public static Address getAddress(String houseNumber, String streetName, 
                                     String city, String region, String postCode, String country){
        Address address = new Address(houseNumber, streetName, city, region, postCode, country);
        return address;
    }
    @Test
    public void testAddress(){
        
        manager.getTransaction().begin();
        manager.persist(getAddress("204B", "Whit Lane", "Salford", "Greater Manchester", "M23 5RS", "UK"));
        manager.getTransaction().commit();
        
        List<Address> add = manager.createQuery("select p from Address p").getResultList();
        
        assertEquals(3, add.size());
        for(Address ad : add){
            
            String hNumber = ad.getHouseNumber();
            String str = ad.getStreet();
            String reg = ad.getRegion();
            String ct = ad.getCountry();
            
            assertTrue(hNumber.equals("204B") && str.equals("Whit Lane") 
                       && reg.equals("Greater Manchester") && ct.equals("UK"));
        }
    }

}
