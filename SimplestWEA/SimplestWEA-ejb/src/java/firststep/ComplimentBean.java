/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class ComplimentBean implements Compliment {
    public ComplimentBean() {
    
    }

    
    
    @Override
    public String compliment(String name) {
        return "You're the best, " + name;
    }

   
}
