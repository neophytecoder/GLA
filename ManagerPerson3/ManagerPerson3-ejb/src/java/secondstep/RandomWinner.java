/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import persistent.Person;
import persistent.PersonManager;

/**
 *
 * @author root
 */
@Singleton
@Startup
public class RandomWinner {
    private Person winner;
    
    @EJB
    PersonManager personManager;
    
    @PostConstruct
    void init() {
        if (winner == null) {
            winner = personManager.find();
            System.out.println("Select winner" + winner);
            
        }
    }

    @Lock(LockType.READ)
    @AccessTimeout(value = 2, unit=TimeUnit.SECONDS)
    public Person getWinner() {
        return winner;
    }

    @Lock(LockType.WRITE)
    @AccessTimeout(value = 1, unit=TimeUnit.SECONDS)
    public void setWinner(Person winner) {
        this.winner = winner;
    }
    
    
}
