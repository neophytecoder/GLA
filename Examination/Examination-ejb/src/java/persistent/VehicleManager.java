/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface VehicleManager {
    void addType(String name, int interval, String licence);
    void addVehicle(int registrationNumber, String brand, String typeName);

    List<Vehicle> findAll();

    List<Vehicle> findAllAvailableVehicle();
    List<Vehicle> findAllNotAvailableVehicle();

    void addDriverVehicle(Driver driver, Vehicle vehicle);

    void findVehicleDriver();
}
