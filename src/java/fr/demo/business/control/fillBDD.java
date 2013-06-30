package fr.demo.business.control;

import fr.demo.business.entity.EnumEtatCommande;
import fr.demo.business.entity.EtatCommande;
import fr.demo.business.entity.Livre;
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

        /*le flush sert à forcer l'écriture dans la base.
         * L'utilisation dans ce cas me permets de garder l'ordre de création des etats avec l'ordre d'insertion.
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
