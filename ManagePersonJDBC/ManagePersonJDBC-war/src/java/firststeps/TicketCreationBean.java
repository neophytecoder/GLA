/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import persistence.Person;
import persistence.TicketManager;
import persistence.WorkflowViolationException;

/**
 *
 * @author cirstea
 */
//@Named(value = "ticketCreationBean")
@ManagedBean
@RequestScoped
public class TicketCreationBean implements Serializable {

    private static final String STATEFUL_TEST_BEAN_KEY = "STATEFUL_TEST_BEAN_KEY";
//    if we inject, we get a new instance for each request (and consequently don't have the right functionality)
    @EJB
    private TicketManager ticketManager;
    
    private String firstname;
    private String lastname;
    private String topic;
    private String issue;
    private String completeMessage;
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String submitTicket() throws ServletException{
        TicketManager ticketManager = getStatefulBean();
        try {
            ticketManager.submitTicket(firstname, lastname);
            return "submitTopic";
        } catch (WorkflowViolationException ex) {
            Logger.getLogger(TicketCreationBean.class.getName()).log(Level.SEVERE, null, ex);
            return error(ex.toString());
        }
       
    }
    
    public String submitTopic() throws ServletException{
        TicketManager ticketManager = getStatefulBean();
        try {
            ticketManager.submitTopic(topic);
            return "submitIssue";
        } catch (WorkflowViolationException ex) {
            Logger.getLogger(TicketCreationBean.class.getName()).log(Level.SEVERE, null, ex);
            return error(ex.toString());
        }
    }
    
    public String submitIssue() throws ServletException{
        TicketManager ticketManager = getStatefulBean();
        try {
            ticketManager.submitIssue(issue);
            completeMessage = ticketManager.completeTicket();
            
            invalidateSessionTicket();
            return "successfulTicket";
        } catch (WorkflowViolationException ex) {
            Logger.getLogger(TicketCreationBean.class.getName()).log(Level.SEVERE, null, ex);
            return error(ex.toString());
        }
    }

    // explicit lookup
    private TicketManager getStatefulBean() throws ServletException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        TicketManager ticketManager = (TicketManager) httpSession.getAttribute(STATEFUL_TEST_BEAN_KEY);
        System.out.println("TicketManager = " + ticketManager);
        if (ticketManager == null) {
            try {
                InitialContext ic = new InitialContext();
                ticketManager = (TicketManager) ic.lookup("java:global/ManagePersonJDBC/ManagePersonJDBC-ejb/TicketmanagerBean");
                httpSession.setAttribute(STATEFUL_TEST_BEAN_KEY, ticketManager);
            } catch (NamingException e) {
                throw new ServletException(e);
            }
        }
        return ticketManager;
    }

    public void invalidateSessionTicket() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.setAttribute(STATEFUL_TEST_BEAN_KEY, null);
    }

    public String getCompleteMessage() {
        return completeMessage;
    }
    
    private String error(String message) {
        this.completeMessage = message;
        invalidateSessionTicket();
        
        return "successfulTicket";
    }
}
