/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.ejb;

import fr.demo.entity.EnumEtatCommande;
import fr.demo.entity.EtatCommande;
import fr.demo.entity.Livre;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adouche Ali
 */
@Singleton
@Startup
public class fillBDD {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void fill() {
        em.persist(new Livre("Java EE 6", "Arun Gupta", "O'REILLY", 10.20D));
        em.persist(new Livre("Java EE 6 development with Netbeans 7 ", "David R. Heffelfinger", "PACKT", 20.5D));
        em.persist(new Livre("EJB 3", "Supinfo", "DUNOD", 30.5D));
        em.persist(new Livre("JSP et Servlet efficaces", "Jean-Luc Déléage", "DUNOD", 40.40D));
        em.persist(new Livre("Real World Java EE Patterns, Rethinking Best Practices", "Adam Bien", "AdamBien edition", 50.60D));
        em.persist(new Livre("Real World Java EE Night Hacks", "Adam Bien", "AdamBien edition", 60.50D));

        /*le flush sert a forcer l'ecriture dans la base.
         * L'utilisation dans ce cas me permets de garder l'ordre de creation des etats avec l'ordre d'insertion.
         */
        em.persist(new EtatCommande(EnumEtatCommande.ECV));//En Cours de Validation 
        em.flush();
        em.persist(new EtatCommande(EnumEtatCommande.VA)); //Validée
        em.flush();
        em.persist(new EtatCommande(EnumEtatCommande.ECL));//En cours de Livraison
        em.flush();
        em.persist(new EtatCommande(EnumEtatCommande.CL));//Cloturée.
    }
}
