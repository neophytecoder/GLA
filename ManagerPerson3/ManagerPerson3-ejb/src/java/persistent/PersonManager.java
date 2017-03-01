/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.util.List;
import java.util.Set;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PersonManager {
    public void addPerson(Person person);
    public void addPerson(Person person, Status status);
    public void addPerson(Person person, Status status, Set<Address> addresses);
    Person find();
    List<Person> findAll();
    public Person findById(int id);
}
