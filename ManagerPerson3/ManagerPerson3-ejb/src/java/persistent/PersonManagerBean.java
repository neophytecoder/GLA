/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author root
 */
@Stateless
public class PersonManagerBean implements PersonManager {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "glaPU")
    private EntityManager em;
    
    @Override
    public void addPerson(Person person) {
        em.persist(person);
    }

    @Override
    public void addPerson(Person person, Status status) {
        em.persist(status);
        person.setStatus(status);
        em.persist(person);
    }
    
    Status findByStatus(String title) {
        TypedQuery<Status> query = em.createQuery("select s from Status s where s.title = ?1 ", Status.class);
        query.setParameter(1, title);
        try {
            return query.getSingleResult();
        } catch (Exception exc) {
            return null;
        }
    }
    
    Address findByAddress(String town) {
        TypedQuery<Address> query = em.createQuery("select a from Address a where a.town = ?1 ", Address.class);
        query.setParameter(1, town);
        try {
            return query.getSingleResult();
        } catch (Exception exc) {
            return null;
        }
    }

    
    @Override
    public void addPerson(Person person, Status status, Set<Address> addresses) {
        Status existingStatus = findByStatus(status.getTitle());
        if (existingStatus == null) {
            em.persist(status);
        }
        
        
        
        Set<Address> addresses2 = new HashSet<>();
        for (Address address: addresses) {
            Address existingAddress = findByAddress(address.getTown());
            if (existingAddress == null) {
                em.persist(address);
                address = existingAddress;
            } 
            addresses2.add(address);
        }
        
        person.setAddresses(addresses2);
        person.setStatus(status);
        em.persist(person);
    }
    
    @Override
    public List<Person> findAll() {
        TypedQuery<Person> persons = em.createQuery("select p from Person p", Person.class);
        return persons.getResultList();
    }
    
    @Override
    public Person find() {
        TypedQuery<Person> persons = em.createQuery("select p from Person p", Person.class);
        try {
            return persons.getResultList().get(0);
        } catch(Exception exc) {
            
        }
        return null;
    }
    
    @Override
    public Person findById(int id) {
        TypedQuery<Person> query = em.createQuery("select p from Person p where p.id = ?1", Person.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
}
