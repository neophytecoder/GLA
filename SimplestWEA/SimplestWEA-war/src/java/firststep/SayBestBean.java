/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import firststep.Compliment;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped; // add cdi-api.jar from directory modules in the glassfish installation
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cirstea
 */
@ManagedBean
@RequestScoped
public class SayBestBean {

    @EJB
    private Compliment compliment;
    
    private String name;
    
    public SayBestBean() {
        name = "Juan";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sayBestJB() {
        return compliment.compliment("James Bond");
    }
    
    public String sayBest() {
        return compliment.compliment(name);
    }
    
    public String compliment() {
        return "Hi Bili";
    }

}
