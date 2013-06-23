/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.ejb;


import fr.demo.cdi.Logging;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author Adouche Ali
 */
@Stateless
@Logging
public class SchedulerBean {
    
    @PersistenceContext
    EntityManager em;

    @Schedule(hour = "*", minute = "*", persistent = false)
    public void print(){
        Long count = em.createQuery("select count(o.id) from WebOrder o", Long.class).getSingleResult();
        if(count == null ) { 
            count = 0L; 
        }
        System.out.println("Currently there are " + count + " orders in the system");
    }   
}
