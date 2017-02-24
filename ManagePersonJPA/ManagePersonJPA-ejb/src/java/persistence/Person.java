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
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable {
    
    @Column(name = "PERSON_FIRST_NAME")
    private String firstName;
    
    @Column(name = "PERSON_LAST_NAME")
    private String lastName;
    
    
    @Column(name = "PERSON_BIRTHDATE")
    private String birthdate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="PERSON_ID")
    private long id;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Status status;
    
    @OneToMany(mappedBy = "person", targetEntity = Address.class, fetch = FetchType.LAZY)
    private Set<Address> addresses;

    public Person() {
    }
    
    
    
    public Person(String firstName, String lastName, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
    

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        Set<Address> addressess = getAddresses();
        addressess.size();
        String str = String.format("%s %s %s %s %s \n", firstName, lastName, birthdate, getStatus().toString(), addressess.toString());
        return str;
    }

    
}
