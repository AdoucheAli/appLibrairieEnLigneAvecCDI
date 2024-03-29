package fr.demo.business.boundary;

import fr.demo.business.control.Logging;
import fr.demo.business.entity.EnumEtatCommande;
import fr.demo.business.entity.EtatCommande;
import fr.demo.business.entity.WebOrder;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Adouche Ali
 */
@Stateless
@Logging
public class OrderProceesor {
    
    @PersistenceContext
    EntityManager em;

    @Asynchronous
    public void saveOrUpdateOrder(@Observes(during = TransactionPhase.AFTER_SUCCESS) final WebOrder order){
        prePersist(order);
        WebOrder webOrder = em.merge(order);
        em.flush();
        order.setId(webOrder.getId());
    }

     private void prePersist(WebOrder order){
        EtatCommande etatCommande = order.getEtatCommande();
        Query q = em.createNamedQuery(EtatCommande.BY_CODE);
        
        if (etatCommande.getId() == null){
            etatCommande = getEtatCommandeFromDB(q, etatCommande.getCode());
                         
        }else{
             etatCommande = getEtatCommandeFromDB(q, etatCommande.getCode().next());
        }
        order.setEtatCommande(etatCommande);
    }
    
    private EtatCommande getEtatCommandeFromDB(Query q, final EnumEtatCommande code) {
        return (EtatCommande)q.setParameter("code", code).getSingleResult();
    }
}
