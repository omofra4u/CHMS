package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.joda.time.DateTime;

@Entity
public class ProgressNote implements Serializable{
    
    private static final long serialVersionUID = -359007283943638802L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private long id;
    
    @Column( nullable = false)
    private String note;
    
    private ServiceUser owner;
    
    private Staff author;
    
    @Column( nullable = false)
    private DateTime timeOfNote;
    
    public ProgressNote(String note, ServiceUser owner, Staff author){
        this.author = author;
        this.owner = owner;
        this.note = note;
        timeOfNote = DateTime.now();
    }
    
    private ProgressNote(){}

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ServiceUser getOwner() {
        return owner;
    }

    public void setOwner(ServiceUser owner) {
        this.owner = owner;
    }

    public Staff getAuthor() {
        return author;
    }

    public void setAuthor(Staff author) {
        this.author = author;
    }

    public DateTime getTimeOfNote() {
        return timeOfNote;
    }

    public void setTimeOfNote(DateTime timeOfNote) {
        this.timeOfNote = timeOfNote;
    }
    

}
