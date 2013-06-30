/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.business.boundary;

import fr.demo.business.entity.WebOrder;
import fr.demo.business.control.Logging;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Adouche Ali
 */
@Stateless
@Logging
public class ServiceOrder {
    
    @PersistenceContext
    EntityManager em;
    
    public List<WebOrder> getOrders(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<WebOrder> query = criteriaBuilder.createQuery(WebOrder.class);
        Root<WebOrder> order = query.from(WebOrder.class);
        query.select(order);
        
        List<WebOrder> orders = em.createQuery(query).getResultList();
        
        if (orders != null){
            for (WebOrder anOrder : orders) { 
                em.refresh(anOrder);               
            }
        }
        return (orders == null ) ? Collections.<WebOrder>emptyList() : orders;
    }
    
}
