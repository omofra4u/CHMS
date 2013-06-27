package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import org.joda.time.DateTime;

public class SupportWorker extends Staff implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -4406818857062403045L;
    
    public SupportWorker(String firstName, String middleName, String lastName,
            DateTime dateOfBirth) {
        super(firstName, middleName, lastName, dateOfBirth);
    }
    
    public SupportWorker(String firstName, String lastName,
            DateTime dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        
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
