/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import persistence.Person;
import persistence.PersonManager;

/**
 *
 * @author root
 */
@Singleton
@Startup
@LocalBean
public class RandomWinnerBean {
    private Person person;
    
    @EJB
    PersonManager personManager;
    
    @PostConstruct
    public void init() {
        System.err.println("init called");
        pickPersonRandomly();
    }
    
    @Schedule(hour = "23")
    private void pickPersonRandomly() {
        person = personManager.pickOne();
        System.err.println("pick ones " + person.getFirstName());
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
}
