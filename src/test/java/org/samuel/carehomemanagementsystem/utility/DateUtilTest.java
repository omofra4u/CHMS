package org.samuel.carehomemanagementsystem.utility;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

//TODO Add more test for the dateutil class
public class DateUtilTest {
    DateTime date = new DateTime("1980-06-9");
    
    @Test (expected = NullPointerException.class)
    public void failIfDateOfBirthIsNull(){
        DateUtil.calculateAge(null);
    }
    
    @Test
    public void succeedIfDateIsRightFormat(){
        assertEquals(33, DateUtil.calculateAge(date));
    }
    

}
