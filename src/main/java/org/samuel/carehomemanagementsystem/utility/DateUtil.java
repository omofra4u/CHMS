package org.samuel.carehomemanagementsystem.utility;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {
    
    public static int calculateAge(DateTime dateOfBirth){
        if (dateOfBirth.equals(null))
            throw new NullPointerException("Date of birth can not be empty");
        
        DateTime currentDate = new DateTime();
        
        Period pet = new Period(dateOfBirth, currentDate);
        return pet.getYears();
    }
    
    public static DateTime convertStringToDate(String date){
        
        if(date.isEmpty() || date.equals(""))
            throw new IndexOutOfBoundsException("Wrong date format");
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
        DateTime formatDate = formatter.parseDateTime(date);
        return formatDate;
    }

}
