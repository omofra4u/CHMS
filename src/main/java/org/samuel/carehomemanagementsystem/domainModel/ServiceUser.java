package org.samuel.carehomemanagementsystem.domainModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.samuel.carehomemanagementsystem.utility.DateUtil;

import com.sun.javafx.beans.annotations.NonNull;

@Entity
public class ServiceUser extends Person{
    
    private static final long serialVersionUID = 6781689908079554525L;

    //    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private DateTime dateOfBirth;
    
    private String nhsNumber;
    private String niNumber;
    private String religion;
    private String firstLanguage;
    private String preferredLanguage;
    private String ethnicOrigin;
    
/*    @Basic(fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Medication> currentMedications;
    
    private List<Medication> oldMedication;*/
    
    @Basic(fetch = FetchType.LAZY)
    @OneToMany
    private List<OldAddress> allOldAddresses;
    
/*    @Basic( fetch = FetchType.LAZY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<ProgressNote> progressNotes;*/
    
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "add_fk", nullable = false)
    private Address currentAddress;
    
    @Transient
    private int age;
    
    public ServiceUser(String firstName, String middleName, String lastName, DateTime dateOfBirth){
        super(firstName, middleName, lastName);
/*        this.progressNotes = new ArrayList<>();
        this.currentMedications = new HashSet<>();
        oldMedication = new ArrayList<>();*/
        this.dateOfBirth = dateOfBirth;
    }
    
    public ServiceUser(String firstName, String lastName, DateTime dateOfBirth){
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
/*        this.progressNotes = new ArrayList<>();
        this.currentMedications = new HashSet<>();*/
        allOldAddresses = new ArrayList<>();
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }
    
    public ServiceUser(){}

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferrefLanguage) {
        this.preferredLanguage = preferrefLanguage;
    }

    public String getEthnicOrigin() {
        return ethnicOrigin;
    }

    public void setEthnicOrigin(String ethnicOrigin) {
        this.ethnicOrigin = ethnicOrigin;
    }

    public int getAge() {
        return calculateAge(dateOfBirth);
    }
    
    public String getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }
    
   /* public List<ProgressNote> getProgressNotes() {
        return progressNotes;
    }

    public void setProgressNotes(List<ProgressNote> progressNotes) {
        this.progressNotes = progressNotes;
    }

    public Set<Medication> getCurrentMedications() {
        return currentMedications;
    }

    public void setCurrentMedications(Set<Medication> currentMedications) {
        this.currentMedications = currentMedications;
    }*/

    public Address getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }
    
    public boolean deleteAddress(Address newAddress){
        OldAddress oldAddress = new OldAddress(currentAddress);
        allOldAddresses.add(oldAddress);
        currentAddress = newAddress;
        return true;
    }
/*    public List<Medication> getOldMedication() {
        return oldMedication;
    }

    public void setOldMedication(List<Medication> oldMedication) {
        this.oldMedication = oldMedication;
    }*/

    public List<OldAddress> getOldAddress() {
        return allOldAddresses;
    }

    public void setOldAddress(List<OldAddress> oldAddress) {
        this.allOldAddresses = oldAddress;
    }

    private int calculateAge(DateTime value){
        
        return DateUtil.calculateAge(value);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if(!(object instanceof ServiceUser))
            return false;
        ServiceUser serviceUser = (ServiceUser)object;
        return serviceUser.getId() == this.getId()
                && serviceUser.getFirstName() == this.getFirstName()
                && serviceUser.getLastName() == this.getLastName()
                && serviceUser.getDateOfBirth() == this.dateOfBirth;
    }
    
    @Override
    public String toString() {
        StringBuilder serviceUser = new StringBuilder("'").append(this.getClass()).append("'\n");
        serviceUser.append("Id           : ").append(this.getId()).append("\n");
        serviceUser.append("Full Names:    ").append(this.getFirstName()).append(" ")
                   .append(this.getMiddleName()).append(" ").append(this.getLastName()).append("\n");
        serviceUser.append("Date of Birth: ").append(this.getDateOfBirth()).append("\n");
        serviceUser.append("Gender       : ").append(this.getGender());
        return serviceUser.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 65 * hash + this.getFirstName().hashCode();
        hash = 65 * hash + this.getLastName().hashCode();
        hash = 65 * hash + this.getDateOfBirth().hashCode();
        return hash;
    }

}
