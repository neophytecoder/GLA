/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistence.Person;
import persistence.PersonManager;

/**
 *
 * @author root
 */

@RequestScoped
@ManagedBean
public class PersonsBean {
    @EJB
    private PersonManager personManager;
    
    @EJB
    RandomWinnerBean randomWinner;
    
    public List<Person> allPersons() {
        return personManager.listPersons();
    }
    
    public String getWinner() {
        return randomWinner.getPerson().getFirstName() + " " + randomWinner.getPerson().getLastName();
    }
}