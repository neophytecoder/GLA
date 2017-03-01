/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import java.util.Set;
import javax.persistence.ManyToOne;

/**
 *
 * @author root
 */
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int registrationNumber;
    private String brand;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date lastMaintenance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date followingMaintenance;
    
    @ManyToOne
    private Type type;
    
    @ManyToMany
    private List<Driver> drivers = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(int registrationNumber, String brand, Date lastMaintenance, Date followingMaintenance) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.lastMaintenance = lastMaintenance;
        this.followingMaintenance = followingMaintenance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public Date getFollowingMaintenance() {
        return followingMaintenance;
    }

    public void setFollowingMaintenance(Date followingMaintenance) {
        this.followingMaintenance = followingMaintenance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
    
    public void addVehicle(Driver driver) {
        drivers.add(driver);
    }
}
