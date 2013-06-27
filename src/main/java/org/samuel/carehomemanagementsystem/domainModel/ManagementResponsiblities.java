package org.samuel.carehomemanagementsystem.domainModel;

public interface ManagementResponsiblities extends StaffResponsibilities{
    
    public boolean addStaff(ManagementStaff staff);
    public boolean addMedication(ManagementStaff staff);
    public boolean deleteMedication(ManagementStaff staff);
    public boolean addServiceUser(ManagementStaff staff);

}
