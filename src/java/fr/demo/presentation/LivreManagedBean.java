/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.presentation;

import fr.demo.business.boundary.ServiceLivre;
import fr.demo.business.entity.Livre;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adouche Ali
 */

@Model
public class LivreManagedBean {

    @Inject
    ServiceLivre serviceLivre;
    
    private List<Livre> livresInCatalogue;
    private String filter;

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    } 

    public List<Livre> getLivresInCatalogue() {
        if (  livresInCatalogue == null ) {
            getLivres();
        }
        return livresInCatalogue;
    }

    public void getLivres() {
        livresInCatalogue = serviceLivre.getLivres(filter);
    }
}
