/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmmmm;

import exammmm.GetAllVehiclesBean;
import exammmm.GetAllVehiclesBeanLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistent.Driver;
import persistent.Vehicle;
import persistent.VehicleManager;
import persistent.VehicleManagerBean;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RegisTypeBean {
    private String name;
    private int interval;
    private String licence;
    
    @EJB
    GetAllVehiclesBeanLocal getAllVehiclesBean;
    
    @EJB
    VehicleManager vehicleManager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    
    public void registerType() {
        vehicleManager.addType(name, interval, licence);
        getAllVehiclesBean.getAllVehicles();
    }
    
    
    public void tryManager() {
        Vehicle vehicle = new Vehicle(1234, "brand", new Date(), new Date());
        Driver driver = new Driver("joko");
        
        vehicleManager.addDriverVehicle(driver, vehicle);
    }
    
    public void tryManager2() {
        
        vehicleManager.findVehicleDriver();
    }
}
