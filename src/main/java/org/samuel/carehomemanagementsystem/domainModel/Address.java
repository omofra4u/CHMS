package org.samuel.carehomemanagementsystem.domainModel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 3528010709858848204L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private String houseNumber;
    
    @Column( nullable = false)
    private String street;
    
    @Column( nullable = false)
    private String city;
    
    private String region;
    
    @Column( nullable = false)
    private String postCode;
    
    @Column( nullable = false)
    private String country;
    
    public Address(){}
    
    public Address(String houseNumber, String streetName,String city, String region, String postCode, String country){
        this.houseNumber = houseNumber;
        this.street = streetName;
        this.city = city;
        this.region = region;
        this.postCode = postCode;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    public String toString(){
        StringBuilder address = new StringBuilder("'").append(this.getClass()).append("'").append("\n");
        address.append("House Number: ").append(this.getHouseNumber()).append("\n");
        address.append("Street Name:  ").append(this.getStreet());
        address.append("\n");
        address.append("City:         ").append(this.getCity());
        address.append("\n");
        address.append("Region:       ").append(this.getRegion());
        address.append("\n");
        address.append("Post Code:    ").append(this.getPostCode());
        address.append("\n");
        address.append("Country:      ").append(this.getCountry());
        return address.toString();
    }

}
