package firststeps;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ejb.EJB;
// import javax.inject.Inject;

import firststep.HelloWorld;
import javax.sound.midi.SysexMessage;


public class HelloWorldClient {

    @EJB
    private static HelloWorld helloWorldBean;
  
  
  public static void main(String [] args) {
      helloWorldBean.sayHello("Juan");
      System.out.println(helloWorldBean.SayGreetings("Test"));
      
        try {
          Context context = new InitialContext();
          HelloWorld helloLook = (HelloWorld)context.lookup("java:global/SimplestWEA/SimplestWEA-ejb/HelloWorldBean");
          helloLook.sayHello("James Bond");
          System.out.println(helloLook.SayGreetings("Karsten"));
          System.out.println("The lookup EJB said hello");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
   
             //use the injected Bean
        try {
          helloWorldBean.sayHello("Vincent Vega");
          System.out.println(helloWorldBean.SayGreetings("Karsten2"));
          System.out.println("The injected EJB said hello");
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        
  } // end main
  
}
