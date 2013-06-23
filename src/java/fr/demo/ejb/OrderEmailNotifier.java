/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.ejb;

import fr.demo.cdi.Logging;
import fr.demo.entity.WebOrder;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adouche Ali
 */
@Stateless
@Logging
public class OrderEmailNotifier {

    @PersistenceContext
    EntityManager em;

    @Asynchronous
    public void sendEmail(@Observes(during = TransactionPhase.AFTER_SUCCESS) final WebOrder order) {
        boolean isSended = false;
        try {
            
            for (int i = 0; i < 2; i++) {
                TimeUnit.SECONDS.sleep(10);
                if (order.getId() != null) {
                    System.out.println("notificaiton email for customer " + order.getCustomer().getName());
                    i++;
                    isSended = true;
                }
            }
            if(!isSended) {
                System.out.println("envoyer un mail a l'admin : probleme order " + order);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(OrderEmailNotifier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
