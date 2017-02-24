/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistence.Person;
import persistence.PersonManager;
/**
 *
 * @author root
 */

@ManagedBean
@RequestScoped
public class FindBean {
    private long id;
    private String message;
    
    @EJB
    PersonManager personManager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    public void findUser() {
        Person person = personManager.findPerson(id);
        message = person.toString();
    }
}
