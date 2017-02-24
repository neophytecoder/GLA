/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class NameHandlerBean implements NameHandler {
    
    @Override
    public String generateNewId(String lastname) {
        Random random = new Random();
        String xx = Math.abs(random.nextInt(1000))*10 + "";
        return lastname+xx.substring(0,2);
    }
    
    @Override
    public String greetingsMessage(String firstname, String lastname, String nickname, String language) {
        if (language.equals("EN")) {
            return "Hello " + firstname + " " + lastname + " (" + nickname + ") ";
        }
        return "Bonjour " + firstname + " " + lastname + " (" + nickname + ") ";
    }
}
