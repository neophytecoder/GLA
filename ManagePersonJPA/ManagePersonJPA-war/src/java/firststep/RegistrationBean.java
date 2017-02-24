/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import java.util.HashSet;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import persistence.Address;
import persistence.Person;
import persistence.PersonManager;
import persistence.Status;
import java.util.Set;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RegistrationBean {
    
    private String firstname;
    private String lastname;
    private String birthdate;
    private String title;
    private String fulltitle;
    private String message;
    private String address1Code;
    private String address1Town;
    private String address2Code;
    private String address2Town;
    
    @EJB
    PersonManager personManager;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public void setFulltitle(String fulltitle) {
        this.fulltitle = fulltitle;
    }
    
    public void registerUser() {
        Person person = new Person(firstname, lastname, birthdate);
        Status status = new Status(title, fulltitle);
        person.setStatus(status);
        
        Person persistedPerson = personManager.addPerson(person);
        
        
        Address address1 = new Address(address1Code, address1Town);
        Address address2 = new Address(address2Code, address2Town);
        address1.setPerson(person);
        address2.setPerson(person);
        
        personManager.addAddress(address1);
        personManager.addAddress(address2);
        
        
        message = "successfully saved";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddress1Code() {
        return address1Code;
    }

    public void setAddress1Code(String address1Code) {
        this.address1Code = address1Code;
    }

    public String getAddress1Town() {
        return address1Town;
    }

    public void setAddress1Town(String address1Town) {
        this.address1Town = address1Town;
    }

    public String getAddress2Code() {
        return address2Code;
    }

    public void setAddress2Code(String address2Code) {
        this.address2Code = address2Code;
    }

    public String getAddress2Town() {
        return address2Town;
    }

    public void setAddress2Town(String address2Town) {
        this.address2Town = address2Town;
    }
    
    
    
    
}
