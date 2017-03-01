/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import persistent.Vehicle;
import persistent.VehicleManager;

/**
 *
 * @author root
 */
@Startup
@Singleton
public class SchedulerBean {
    @EJB
    VehicleManager manager;
    
    @EJB
    MailSenderBean sender;
    
    @Resource
    TimerService timerService;
    
    
    @PostConstruct
    void init() {
        //Timer timer = timerService.createIntervalTimer(10000, 1000 * 60 * 60, new TimerConfig());
    }

    //@Schedule(hour = "*", minute = "*", second = "*/10")
    @Timeout
    public void doSomething(Timer timer) {
//        List<Vehicle> vehicles = manager.findAll();
//        Date today = Calendar.getInstance().getTime();
//        for (Vehicle vehicle : vehicles) {
//            Date followingDate = vehicle.getFollowingMaintenance();
//            if (followingDate.before(today)) {
//                sender.sendEmail(vehicle.getRegistrationNumber()+" " +vehicle.getBrand());
//            }
//        }
//        System.out.println("doSomething is called");
    }
}
