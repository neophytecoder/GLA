/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistent.Person;
import persistent.PersonManager;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class PersonsBean {
    @EJB
    PersonManager personManager;
    
    @EJB
    RandomWinner randomWinner;
    
    public List<Person> allPersons() {
        return personManager.findAll();
    }
    
    public String winner() {
        return randomWinner.getWinner().getNickName();
    }
}
