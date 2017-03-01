/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class NameHandlerBean implements NameHandler {

    @Override
    public String generateNickName(String lastName) {
        return lastName+20;
    }

    @Override
    public String greetingMessage(String firstName, String lastName, String nickName) {
        return "Bonjour " + firstName + " " + lastName + "(" + nickName + ")";
    }

    
}
