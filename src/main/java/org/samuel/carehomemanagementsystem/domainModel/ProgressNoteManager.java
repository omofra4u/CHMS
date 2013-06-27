package org.samuel.carehomemanagementsystem.domainModel;

public class ProgressNoteManager implements StaffResponsibilities{
    
    private Staff staff;
    private ServiceUser serviceUser;
    
    public ProgressNoteManager(Staff staff, ServiceUser serviceUser){
        this.staff = staff;
        this.serviceUser = serviceUser;
    }

    @Override
    public void perform() {
        
        //TODO: Think about how to implement this behaviour.
        // Get the list of all staff that are allowed to work with this service user,
        // if this the staff is among the list, return true; 
        
    }

}
