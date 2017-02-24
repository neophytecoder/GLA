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
public interface TicketManager {

    void submitTicket(String firstName, String lastName)  throws WorkflowViolationException ;

    void submitTopic(String topic)  throws WorkflowViolationException ;

    void submitIssue(String issue) throws WorkflowViolationException ;

    String completeTicket() throws WorkflowViolationException ;

   
}
