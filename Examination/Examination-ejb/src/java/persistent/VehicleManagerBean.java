/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import exammmm.ApplicationLogger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
@Interceptors({ApplicationLogger.class})
public class VehicleManagerBean implements VehicleManager {
    @PersistenceContext(unitName = "garagePU")
    EntityManager entityManager;

    @Override
    public void addType(String name, int interval, String licence) {
        Type type = new Type(name, interval, licence);
        entityManager.persist(type);
    }
    
    @Override
    public void addVehicle(int registrationNumber, String brand, String typeName) {
        Type aType = null;
        try {
            TypedQuery<Type> query = entityManager.createQuery("select t from Type t where t.name= ?1", Type.class);
            query.setParameter(1, typeName);
            aType = query.getSingleResult();
        } catch(Exception exc) {
            TypedQuery<Type> query = entityManager.createQuery("select t from Type t", Type.class);
            aType = query.getResultList().get(0);
        } 
        Vehicle vehicle = new Vehicle();
        vehicle.setRegistrationNumber(registrationNumber);
        vehicle.setBrand(brand);
        vehicle.setType(aType);
        Date currentDate = new Date();
        vehicle.setLastMaintenance(currentDate);
        Calendar calendar = Calendar.getInstance(); // current date
        calendar.add(Calendar.MONTH, aType.getMaintenanceInterval()); // current date += type.getInterval()
        Date followingDate = calendar.getTime();
        vehicle.setFollowingMaintenance(followingDate);
        entityManager.persist(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createQuery("select v from Vehicle v", Vehicle.class);
        return query.getResultList();
    }

    @Override
    public List<Vehicle> findAllAvailableVehicle() {
        TypedQuery<Vehicle> query = entityManager.createQuery("select v from Vehicle v where v.followingMaintenance > ?1", 
                Vehicle.class);
        System.out.println(Calendar.getInstance().getTime()+"");
        query.setParameter(1, Calendar.getInstance().getTime(), TemporalType.DATE);
        return query.getResultList();
    }
    
    @Override
    public List<Vehicle> findAllNotAvailableVehicle() {
        TypedQuery<Vehicle> query = entityManager.createQuery("select v from Vehicle v where v.followingMaintenance <= ?1",
                Vehicle.class);
        query.setParameter(1, Calendar.getInstance().getTime(), TemporalType.TIMESTAMP);
        return query.getResultList();
    }

    @Override
    public void addDriverVehicle(Driver driver, Vehicle vehicle) {
        entityManager.persist(driver);
        vehicle.addVehicle(driver);
        entityManager.persist(vehicle);
    }

    @Override
    public void findVehicleDriver() {
        TypedQuery<Vehicle> query = entityManager.createQuery("select v from Vehicle v join fetch v.drivers d", 
                Vehicle.class);
        Vehicle vehicle = query.getResultList().get(0);
        System.out.println(vehicle.getDrivers());
    }
    
    
    
    
}
