package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import org.joda.time.DateTime;

public class ManagementStaff extends Staff implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 7529524708591461910L;
    
    public ManagementStaff(String firstName, String middleName, String lastName,
            DateTime dateOfBirth) {
        super(firstName, middleName, lastName, dateOfBirth);
    }
    
    public ManagementStaff(String firstName, String lastName,
            DateTime dateOfBirth) {
        super(firstName, lastName, dateOfBirth);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean equals(Object object) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
