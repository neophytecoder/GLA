/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PersonManager {

    Person addPerson(Person person);

    Address addAddress(Address Address);

    Person findPerson(long id);
    
}
