/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface Compliment {
    String compliment(String name);
    
}
