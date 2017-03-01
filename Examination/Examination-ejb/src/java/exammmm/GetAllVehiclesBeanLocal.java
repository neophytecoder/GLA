/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmm;

import java.util.List;
import javax.ejb.Local;
import persistent.Vehicle;

/**
 *
 * @author root
 */
@Local
public interface GetAllVehiclesBeanLocal {
    List<Vehicle> getAllVehicles();
}
