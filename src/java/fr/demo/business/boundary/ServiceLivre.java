package fr.demo.business.boundary;

import fr.demo.business.control.Logging;
import fr.demo.business.entity.Livre;
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
public class ServiceLivre {

    @PersistenceContext
    EntityManager em;

    public List<Livre> getLivres(String filter) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Livre> query = criteriaBuilder.createQuery(Livre.class);
        Root<Livre> livre = query.from(Livre.class);
        query.select(livre);
        query.orderBy(criteriaBuilder.asc(livre.get("titre")));
        
        if (filter != null) {
            query.where(criteriaBuilder.like(livre.<String>get("titre"), filter + "%"));
        }

        List<Livre> livres = em.createQuery(query).getResultList();

        return (livres == null) ? Collections.<Livre>emptyList() : livres;
    }

    public List<Livre> getLivres() {
        return getLivres(null);
    }

    public Livre findById(Long livreId) {
        return em.find(Livre.class, livreId);
    }
}
