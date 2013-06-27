package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.samuel.carehomemanagementsystem.utility.MedicationType;

//TODO complete toString method
@Entity
public class Medication implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    @Column(nullable = false)
    private String name;
    private String indication;
    
    @Column(nullable = false)
    private String totalDosagePerDay;
    private String sideEffect;
    private String prescribedBy;
    private String dispensedBy;
    private String personResponsibleForReview;
    private boolean isTakenIndependently;
    
    @Temporal(TemporalType.DATE)
    private DateTime dateOfNextReview;
    
    @Temporal(TemporalType.DATE)
    private DateTime startDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime timeTobeTaken;
    
    @ManyToOne
    private ServiceUser owner;
    
    @Enumerated(EnumType.ORDINAL)
    private MedicationType type;
    
    public Medication(String name, String indication, DateTime timeToBeTaken){
        this.setIndication(indication);
        this.timeTobeTaken = timeToBeTaken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getTotalDosagePerDay() {
        return totalDosagePerDay;
    }

    public void setTotalDosagePerDay(String totalDosagePerDay) {
        this.totalDosagePerDay = totalDosagePerDay;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public String getDispensedBy() {
        return dispensedBy;
    }

    public void setDispensedBy(String dispensedBy) {
        this.dispensedBy = dispensedBy;
    }

    public String getPersonResponsibleForReview() {
        return personResponsibleForReview;
    }

    public void setPersonResponsibleForReview(String personResponsibleForReview) {
        this.personResponsibleForReview = personResponsibleForReview;
    }

    public boolean isTakenIndependently() {
        return isTakenIndependently;
    }

    public void setTakenIndependently(boolean isTakenIndependently) {
        this.isTakenIndependently = isTakenIndependently;
    }
    
    public DateTime getDateOfNextReview() {
        return dateOfNextReview;
    }

    public void setDateOfNextReview(DateTime dateOfNextReview) {
        this.dateOfNextReview = dateOfNextReview;
    }
    
    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }
    
    public DateTime getTimeTobeTaken() {
        return timeTobeTaken;
    }

    public void setTimeTobeTaken(DateTime timeTobeTaken) {
        this.timeTobeTaken = timeTobeTaken;
    }
    
    public MedicationType getType() {
        return type;
    }

    public void setType(MedicationType type) {
        this.type = type;
    }
    
    @Column(nullable = false, length = 50)
    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }
    
    public ServiceUser getOwner() {
        return owner;
    }

    public void setOwner(ServiceUser owner) {
        this.owner = owner;
    }
    
    public String medicationDetails(){
        StringBuilder medication = new StringBuilder();
        medication.append("Name:         ").append(this.getName()).append("\n");
        medication.append("Type:         ").append(this.getType()).append("\n");
        medication.append("Indication:   ").append(this.getIndication()).append("\n");
        medication.append("Total Dosage: ").append(this.getTotalDosagePerDay()).append("\n");
        medication.append("Start Date:   ").append(this.getStartDate()).append("\n");
        return medication.toString();
    }
    
    public String toString(){
        StringBuilder medication = new StringBuilder("'").append(this.getClass()).append("'\n");
        this.medicationDetails();
        return medication.toString();
    }

}
