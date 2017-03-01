/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondstep;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/OrderQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "fragile = 1")
})
public class MDBean1 implements MessageListener {
    
    public MDBean1() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            String out = message.getStringProperty("body");
            System.out.println("******MDBean1**********"+out);
        } catch (JMSException ex) {
            Logger.getLogger(MDBean1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
