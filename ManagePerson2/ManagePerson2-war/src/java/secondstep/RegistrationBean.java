/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    private SessionBean2 nameHandler;

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
    
    public String registerUser() {
        return "registrationOK";
    }
    
    public String registeredUser() {
        if (nickname == null) {
            //nickname = nameHandler.generateNickName(lastname);
        }
        //return nameHandler.greetingMessage(firstname, lastname, nickname);
        return "";
    }
}
