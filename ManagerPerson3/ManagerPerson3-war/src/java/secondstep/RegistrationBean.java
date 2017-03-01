/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import java.util.HashSet;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import persistent.Person;
import persistent.PersonManager;
import persistent.Status;
import java.util.Set;
import persistent.Address;

/**
 *
 * @author root
 */
@ManagedBean
@RequestScoped
public class RegistrationBean {
    private String firstname;
    private String lastname;
    private String nickname;
    private String language;
    private String title;
    private String fullTitle;
    
    private String code1;
    private String town1;
    private String code2;
    private String town2;
    
    private int findId;
    
    @EJB
    ProducerBean producerBean;
    
    @EJB
    private NameHandler2 nameHandler;
    
    @EJB
    private PersonManager personManager;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickName) {
        this.nickname = nickName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getTown1() {
        return town1;
    }

    public void setTown1(String town1) {
        this.town1 = town1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getTown2() {
        return town2;
    }

    public void setTown2(String town2) {
        this.town2 = town2;
    }
    
    
    
    
    public String registerUser() {
        if (nickname == null || nickname.length()==0) {
            nickname = nameHandler.generateNickName(lastname);
        }
        Status status = new Status(title, fullTitle);
        Person person = new Person(firstname, lastname, nickname);
        
        Set<Address> addresseses = new HashSet<>();
        if (code1 != null && code1.length() > 0 || town1 != null) {
            Address address = new Address(code1, town1);
            addresseses.add(address);
        }
        if (code2 != null && code2.length() > 0 || town2 != null) {
            Address address = new Address(code2, town2);
            addresseses.add(address);
        }
        
        personManager.addPerson(person, status, addresseses);
        return "registrationOK";
    }
    
    public String registeredUser() {
        return nameHandler.greetingMessage(firstname, lastname, nickname);
    }

    public int getFindId() {
        return findId;
    }

    public void setFindId(int findId) {
        this.findId = findId;
    }
    
    
    
    public void search() {
        producerBean.sendOrder(searchResult(),1);
        producerBean.sendOrder(searchResult(),2);
        producerBean.sendOrder(searchResult(),1);
        //producerBean.sendTopic(searchResult());
    }
    
    public String searchResult() {
        try {
            return personManager.findById(findId)+"";
        } catch(Exception exc) {
            return "exc";
        }
    }
    
    
}
