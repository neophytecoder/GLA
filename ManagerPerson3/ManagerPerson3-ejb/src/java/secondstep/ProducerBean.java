/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;

/**
 *
 * @author root
 */
@Stateless
@LocalBean
public class ProducerBean {
    @Inject
    JMSContext context;
    
    @Resource(lookup = "jms/OrderQueue")
    Destination orderQueue;
    
    public void sendOrder(String amessage, int type) {
        Message msg = context.createMessage();
        try {
            msg.setStringProperty("body", amessage);
            msg.setIntProperty("fragile", type);
        } catch (JMSException ex) {
            Logger.getLogger(ProducerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(context+"\n"+orderQueue);
        context.createProducer().send(orderQueue, msg);
    }
}
