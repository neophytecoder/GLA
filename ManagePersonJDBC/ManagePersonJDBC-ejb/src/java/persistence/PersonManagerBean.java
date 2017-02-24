/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author root
 */
@Stateless
public class PersonManagerBean implements PersonManager {

    @Resource(lookup="jdbc/gla")
    DataSource dataSource;
    Connection connection;
    
    @PostConstruct
    public void init() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException exc) {
            System.out.println("persistence.PersonManagerBean.init() " + exc);
        }
    }
    
    @PreDestroy
    public void cleanUp() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException exc) {
            System.out.println("persistence.PersonManagerBean.cleanUp() " + exc);
        }
    }
    
    @Override
    public List<Person> listPersons() {
        try {
            List<Person> persons = new ArrayList<>();
            Statement stmnt = connection.createStatement();
            String sql = "SELECT * FROM PERSONS";
            ResultSet rs = stmnt.executeQuery(sql);
            while (rs.next()) {
                Person person = toPerson(rs);
                persons.add(person);
            }
            System.out.println("persistence.PersonManagerBean.allPersons() " + persons);
            return persons;
        } catch (SQLException exc) {
            System.out.println("persistence.PersonManagerBean.allPersons() " + exc);
            return null;
        }
    }
    
    private Person toPerson(ResultSet rs) {
        try {
            Person person = new Person(rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname"), rs.getString("language"));
            return person;
        } catch (SQLException ex) {
            Logger.getLogger(PersonManagerBean.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("persistence.PersonManagerBean.toPerson() " + ex);
            return null;
        }
    }
    
    @Override
    public Person addPerson(Person person) {
        try {
            Statement stmnt = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO PERSONS(NICKNAME, FIRSTNAME, LASTNAME, LANGUAGE) VALUES('%s','%s','%s','%s')",
                    person.getNickName(), person.getFirstName(), person.getLastName(), person.getLanguage());
            stmnt.execute(sql);
            return person;
        } catch(SQLException exc) {
            System.out.println("persistence.PersonManagerBean.addPerson() " + exc);
            return null;
        }
    }
    
    @Override
    public Person pickOne() {
        String sql = "SELECT * FROM PERSONS";
        try {
            Statement stmnt = connection.createStatement();
                
            ResultSet rs = stmnt.executeQuery(sql);
            rs.next();
            return toPerson(rs);
        } catch (SQLException exc) {
            System.out.println("persistence.PersonManagerBean.pickOne() " + exc);
            return null;
        }
    }
    
}
