/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmmmm;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistent.VehicleManager;
import persistent.VehicleManagerBean;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RegisVehicleBean {
    private int registrationNumber;
    private String brand;
    private String type;
    
    @EJB
    VehicleManager vehicleManager;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    public void registerVehicle() {
        vehicleManager.addVehicle(registrationNumber, brand, type);
    }
    
}
