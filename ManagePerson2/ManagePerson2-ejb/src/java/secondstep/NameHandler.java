/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface NameHandler {

    String generateNickName(String lastName);

    String greetingMessage(String firstName, String lastName, String nickName);
    
}
