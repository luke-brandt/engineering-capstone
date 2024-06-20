package com.skylinecoffee.springbootapp.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="Members")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotBlank(message = "First Name cannot be empty")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Size(max = 50)
    private String lastName;

    @Email(message = "Must be a valid email address")
    @NotBlank(message = "Email cannot be empty")
    @Size(max = 100)
    private String email;

    @NotBlank(message = "Address cannot be empty")
    @Size(max = 255)
    private String address;

    @NotBlank(message = "City cannot be empty")
    @Size(max = 100)
    private String city;

    @NotBlank(message = "State cannot be empty")
    @Size(max = 100)
    private String state;

    @NotBlank(message = "Zip Code cannot be empty")
    @Size(max = 10)
    private String zipCode;

    @CreationTimestamp
    private Date dateCreated;

    public Member(){

    }

    public Member(String firstName, String lastName, String email, String address, String city, String state, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Member(long id, String firstName, String lastName, String email, String address, String city, String state, String zipCode, Date dateCreated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
