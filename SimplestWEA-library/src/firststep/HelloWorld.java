/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststep;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface HelloWorld {

    public void sayHello(String name);

    public String SayGreetings(String name);
    
}
