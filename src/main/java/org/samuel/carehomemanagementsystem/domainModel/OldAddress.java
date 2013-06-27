package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

@Entity
public class OldAddress implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 6719725740438218062L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    @Column(name = "oldAddress", nullable = false)
    private Address currentAddress;
    
    public OldAddress(){}
    public OldAddress(Address currentAddress){
        this.currentAddress = currentAddress;
        dateOfdeletion = DateTime.now();
    }
    
    public Address getCurrentAddress() {
        return currentAddress;
    }

    @SuppressWarnings("unused")
    private void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }

    public DateTime getDateOfdeletion() {
        return dateOfdeletion;
    }

    @SuppressWarnings("unused")
    private void setDateOfdeletion(DateTime dateOfdeletion) {
        this.dateOfdeletion = dateOfdeletion;
    }

    private DateTime dateOfdeletion;
    
    public String toString(){
        StringBuilder oldAddress = new StringBuilder();
        oldAddress.append(currentAddress.toString());
        oldAddress.append("\n");
        oldAddress.append(dateOfdeletion).append("\n");
        return oldAddress.toString();
    }
    
}
