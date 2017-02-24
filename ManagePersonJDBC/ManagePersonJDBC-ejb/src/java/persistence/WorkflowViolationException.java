/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author cirstea
 */
public class WorkflowViolationException extends Exception{
    
     public WorkflowViolationException(String message) {
        super(message);
    }
}
