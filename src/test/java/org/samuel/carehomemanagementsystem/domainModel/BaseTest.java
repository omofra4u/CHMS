package org.samuel.carehomemanagementsystem.domainModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    
    private static final String PERSISTENCE_UNIT_NAME = "care_homemanagement_system_app";
    protected EntityManagerFactory factory;
    protected EntityManager manager;
    
    @Before
    public void setUp() throws Exception{
        Logger log = LoggerFactory.getLogger(ServiceUserTest.class);
        
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = factory.createEntityManager();
        
    }
    
    @After
    public void cleanUp(){
        manager.close();
    }

}
