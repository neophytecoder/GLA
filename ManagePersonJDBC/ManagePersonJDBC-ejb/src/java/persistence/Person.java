/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author cirstea
 */
import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String nickName;
    private String language;

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String nickName, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.language = language;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + nickName;
    }

    
}
