package org.samuel.carehomemanagementsystem.domainModel;

public class Gp extends Person {
    
    private Address gpAddress;
    
    public Gp(String firstName, String middleName, String lastName){
        super(firstName, middleName, lastName);
    }
    
    public Gp(String firstName, String lastName){
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals(Object object) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return 0;
    }
    
    

}
