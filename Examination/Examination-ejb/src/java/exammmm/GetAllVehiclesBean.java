/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistent.Vehicle;
import persistent.VehicleManager;

/**
 *
 * @author root
 */
@Stateless
public class GetAllVehiclesBean implements GetAllVehiclesBeanLocal {
    @EJB
    VehicleManager manager;
    
    @EJB
    MailSenderBean sender;
    
    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles =  manager.findAllNotAvailableVehicle();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getRegistrationNumber()+"not available");
            sender.sendEmail("need maintenance" + vehicle.getRegistrationNumber());
        }
        return manager.findAllAvailableVehicle();
    }
}
