/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PersonManagerBean implements PersonManager {

    @PersistenceContext(unitName = "glaPU")
    private EntityManager em;
    
    @Override
    public Person addPerson(Person person) {
        em.persist(person);
        return person;
    }

    @Override
    public Address addAddress(Address address) {
        em.persist(address);
        return address;
    }

    @Override
    public Person findPerson(long id) {
        Person person = em.find(Person.class, id);
        return person;
    }

    
   
}
