/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exammmm;

import com.sun.xml.internal.ws.client.AsyncResponseImpl;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class MailSenderBean {
    
    @Asynchronous
    public Future<Integer> sendEmail(String msg) {
        // do send email
        // call method send_email("resp@garage.com", msg);
        System.out.println("sending a message" + msg);
        return new AsyncResult<Integer>(-1);
    }
}
