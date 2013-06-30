/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.presentation;

import fr.demo.business.control.Livres;
import fr.demo.business.entity.Customer;
import fr.demo.business.entity.Livre;
import fr.demo.business.entity.WebOrder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Adouche Ali
 */
@Named
@SessionScoped
public class BasketManagedBean implements Serializable{
    
    @Inject @Livres
    List<Livre> livresInBasket;
    
    @Inject
    Customer customer;

    @Inject
    FacesContext facesContext;

    @Inject 
    Event<WebOrder> listenerOrder;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    public void addLivre(Livre livre){
        livresInBasket.add(livre);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"success","ajout livre " + livre.getTitre());
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        facesContext.addMessage(null, msg);
    }

    public List<Livre> getLivresInBasket() {
        return livresInBasket;
    }

    public double getTotal(){
        double total = 0;
        for (Livre livre : livresInBasket) {
            total += livre.getPrix();
        }
        return total;
    }
    
    
    public String checkout(){
        listenerOrder.fire(new WebOrder(customer, livresInBasket));
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"success","checkout suucced : " + customer.getName() + " a acheté " + livresInBasket.size()+ " livres ");
        //FacesContext.getCurrentInstance().addMessage(null, msg);
        facesContext.addMessage(null, msg);
        livresInBasket.clear();
        
        return "index.xhtml";
    }
    
}
