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
public class HelloWorldBean implements HelloWorld {
    
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    @Override
    public String SayGreetings(String name) {
        return "Hello " + name;
    }

   
}
