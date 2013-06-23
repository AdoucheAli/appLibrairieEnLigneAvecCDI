/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.cdi;

import fr.demo.entity.Livre;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adouche Ali
 */
public class Configurator {
    
    @Produces @Livres
    public List<Livre> configuresString(){
         
         return new ArrayList<Livre>();
     }
    
    @Produces
    public Boolean configuresBoolean(){
         
         return true;
     }
    
    @Produces @RequestScoped 
    public FacesContext getFacesContext() {
         return FacesContext.getCurrentInstance();
    }
    
    
}
