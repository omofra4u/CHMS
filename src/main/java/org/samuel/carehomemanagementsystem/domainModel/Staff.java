package org.samuel.carehomemanagementsystem.domainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.joda.time.DateTime;
import org.samuel.carehomemanagementsystem.utility.DateUtil;

@Entity
public abstract class Staff extends Person{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    
    @Column( nullable = false)
    private DateTime dateOfBirth;
    
    @Column(nullable = false)
    private String passWord;
    
    @Column(nullable = false)
    private String userName;
    
    private Address address;
    
    
    public Staff(String firstName, String middleName, String lastName, DateTime dateOfBirth){
        super(firstName, middleName, lastName);
        this.dateOfBirth = dateOfBirth;
    }
    
    public Staff(String firstName, String lastName, DateTime dateOfBirth){
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public int getAge(){
        return DateUtil.calculateAge(dateOfBirth);
    }


}
