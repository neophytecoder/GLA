/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import persistence.Person;
import persistence.PersonManager;

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
    
    @EJB
    NameHandler nameHandler;
    
    @EJB
    PersonManager personManager;
    
    @EJB
    RandomWinnerBean randomWinner;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    public String registerUser() {
        if (nickname == null || nickname.length()==0) {
            nickname = nameHandler.generateNewId(lastname);
        }
        
        Person person = new Person(firstname, lastname, nickname,language);
        Person result = personManager.addPerson(person);
        if (result != null) {
            return "registrationOK";
        } else {
            return "registrationKO";
        }
    }
    
    public String pickWinner() {
        String nextPage = registerUser();
        if (nextPage.equals("registrationOK")) {
            Person person = new Person(firstname, lastname, nickname,language);
            randomWinner.setPerson(person);
        }
        return nextPage;
    }
    
    public String registeredUser() {
        return nameHandler.greetingsMessage(firstname, lastname, nickname, language);
    }
}
