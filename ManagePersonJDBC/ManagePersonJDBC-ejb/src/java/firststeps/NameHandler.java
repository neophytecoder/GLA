/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firststeps;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface NameHandler {

    public String generateNewId(String lastname);
    public String greetingsMessage(String firstname, String lastname, String nickname, String language);
}
