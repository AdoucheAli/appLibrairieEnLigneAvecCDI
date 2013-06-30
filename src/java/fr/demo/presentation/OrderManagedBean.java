/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.presentation;

import fr.demo.business.boundary.ServiceOrder;
import fr.demo.business.entity.EnumEtatCommande;
import fr.demo.business.entity.WebOrder;
import java.util.List;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adouche Ali
 */
@Model
public class OrderManagedBean {

    @Inject
    ServiceOrder serviceOrder;
    
    @Inject 
    Event<WebOrder> listenerOrder;
    
    private final  String ETAT_CLOTURE = EnumEtatCommande.CL.getNom();
    
    public List<WebOrder> getOrders(){
        return serviceOrder.getOrders();
    }
    
    public void nextEtat(WebOrder order){
        listenerOrder.fire(order);
        
    }

    public String getETAT_CLOTURE() {
        return ETAT_CLOTURE;
    }   
}
