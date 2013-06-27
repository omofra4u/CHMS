package org.samuel.carehomemanagementsystem.utility;

public class GenderConverter implements Converter{
    
    private final String MALE_GENDER = "MALE";
    private final String FEMALE_GENDER = "FEMALE";

    @Override
    public Gender getGenderAsEnum(String gender) {
        if(gender.isEmpty()|| gender.equals(null)){
            throw new NullPointerException("Gender can not be empty or null");
        }
        if(gender.equalsIgnoreCase(MALE_GENDER))
            return Gender.MALE;
        else
        return Gender.FAMALE;
    }

    @Override
    public String getGenderAsString(Gender gender) {
        
        String genderAsString = null;
        switch(gender){
        case MALE:
            genderAsString =  MALE_GENDER;
            break;
        case FAMALE:
            genderAsString = FEMALE_GENDER;
        }
        return genderAsString;
    }

}
