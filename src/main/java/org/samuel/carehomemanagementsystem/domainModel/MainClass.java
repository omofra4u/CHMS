package org.samuel.carehomemanagementsystem.domainModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.samuel.carehomemanagementsystem.utility.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass /*extends Application*/{

    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("care_homemanagement_system_app");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        Address add = new Address("99", "Bill Street", "Manchester", "Lancashire", "M6 7BB", "UK");
        
        ServiceUser su = new ServiceUser("Samuel", "Odihiri", DateUtil.convertStringToDate("22-09-1980")); 
        su.setCurrentAddress(add);
        em.persist(add);
        em.persist(su);
        em.getTransaction().commit();
        
/*        List<ServiceUser>su = em.createQuery("select p from ServiceUser p").getResultList();
        for(ServiceUser u:su){
            if(u.getId() == 2){
                
                Address add = new Address("24", "Foxville Street", "Salford", "Lancashire", "M6 7BB", "UK");
                u.deleteAddress(add);
                em.getTransaction().begin();
                em.persist(add);
                em.getTransaction().commit();
                List<OldAddress> oldAdd = u.getOldAddress();
                System.out.println("Old Address");
                for(OldAddress a: oldAdd){
                    System.out.println(a.toString());
                    System.out.println();
                }
                System.out.println("Current Address");
                System.out.println(u.getCurrentAddress().toString());
                
            }
        }*/
        
        em.close();
        
    }

}
