/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.ResultSet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PersonManager {
    public Person addPerson(Person person);
    public List<Person> listPersons();
    public Person pickOne();
}
