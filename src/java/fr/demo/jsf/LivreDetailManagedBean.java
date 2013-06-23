/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.jsf;

import fr.demo.ejb.ServiceLivre;
import fr.demo.entity.Livre;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author Adouche Ali
 */
@Model
public class LivreDetailManagedBean {
    
    @Inject
    ServiceLivre serviceLivre;
    
    private Livre livre;
    private Long livreId;
    
    public void loadLivre(){
        
        livre = serviceLivre.findById(livreId);
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }
    
    
}
