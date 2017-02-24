/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateful
public class TicketmanagerBean implements TicketManager {
    private String firstname;
    private String lastname;
    private String topic;
    private String issue;

    @Override
    public void submitTicket(String firstName, String lastName) throws WorkflowViolationException {
        System.out.println("persistence.TicketmanagerBean.submitTicket() " );
        
        if (topic != null || issue != null) {
            throw new WorkflowViolationException("ticket has to be the first step.");
        }
        
        this.firstname = firstName;
        this.lastname = lastName;
    }

    @Override
    public void submitTopic(String topic) throws WorkflowViolationException {
        System.out.println("persistence.TicketmanagerBean.submitTopic()");
        
        if (firstname == null || lastname == null || issue != null) {
            throw new WorkflowViolationException("ticket has to be the second step.");
        }
        
        this.topic = topic;
    }

    @Override
    public void submitIssue(String issue) throws WorkflowViolationException {
        System.out.println("persistence.TicketmanagerBean.submitIssue()");
        
        if (topic == null || firstname == null || lastname == null) {
            throw new WorkflowViolationException("ticket has to be the third step.");
        }
        
        this.issue = issue;
    }

    @Override
    @Remove
    public String completeTicket() {
        Person person = new Person(firstname, lastname, "", "");
        Ticket ticket = new Ticket(person, topic, issue);
        return ticket.toString();
    }
    
    
    @PreDestroy
    public void cleanUp() {
        System.out.println("persistence.TicketmanagerBean.cleanUp()");
    }
    
    
}
