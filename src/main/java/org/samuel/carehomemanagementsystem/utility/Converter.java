package org.samuel.carehomemanagementsystem.utility;

public interface Converter {
    
    public Gender getGenderAsEnum(String gender);
    public String getGenderAsString(Gender gender);

}
