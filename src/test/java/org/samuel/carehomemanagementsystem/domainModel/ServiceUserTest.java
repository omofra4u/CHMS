package org.samuel.carehomemanagementsystem.domainModel;

import static org.junit.Assert.*;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.samuel.carehomemanagementsystem.utility.*;

public class ServiceUserTest extends BaseTest{
    
    
    @Test
    public void insertAndRetrieveServiceUser(){
        Address ad1 = AddressTest.getAddress("204B", "Whit Lane", "Salford", "Greater Manchester", "M23 5RS", "UK");
        Address ad2 = AddressTest.getAddress("24", "Costa Road", "Manchester", "Greater Manchester", "M45 4BS", "UK");
        manager.getTransaction().begin();
        ServiceUser s1 = createServiceUser("Samuel", "Odihiri", "Francis", DateUtil.convertStringToDate("20-05-1995"), 
                                          "SH 05 33 24 B","BSC 23987","English", "Christian", "British", 
                                          "English", "Male");
        
        s1.setCurrentAddress(ad1);
        
        ServiceUser s2 = createServiceUser("Claire", "Donaldson", "Robson", DateUtil.convertStringToDate("10-05-1992"), 
                "SJ 05 33 24 F","BSC 23987","Italian", "Catholic", "Italian", 
                "English", "Female");
        
        s2.setCurrentAddress(ad2);
        
        manager.persist(s1);
        manager.persist(s2);
        manager.persist(ad2);
        manager.persist(ad1);
        manager.getTransaction().commit();
        
        List<ServiceUser> serviceUsers = manager.createQuery("select p from ServiceUser p").getResultList();
        assertEquals(2, serviceUsers.size());
        
        for(ServiceUser su : serviceUsers){
            
            String firstName = su.getFirstName();
            assertTrue(firstName.equals("Samuel") || firstName.equals("Claire"));
        }
        
    }
    
    public ServiceUser createServiceUser(String firstName, String middleName, String lastName, DateTime dateOfBirth,
                                         String niNumber, String nhsNumber, String preferredLanguage, String religion,
                                         String ethnicOrigin, String firstLanguage, String gender){
        ServiceUser su = new ServiceUser(firstName, middleName, lastName, dateOfBirth);
        su.setEthnicOrigin(ethnicOrigin);
        su.setFirstLanguage(firstLanguage);
        su.setNhsNumber(nhsNumber);
        su.setNiNumber(niNumber);
        su.setReligion(religion);
        su.setPreferredLanguage(preferredLanguage);
        GenderConverter sex = new GenderConverter();
        su.setGender(sex.getGenderAsEnum(gender));
        return su;
    }

}
