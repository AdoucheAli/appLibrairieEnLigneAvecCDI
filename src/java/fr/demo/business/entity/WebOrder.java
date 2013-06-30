package fr.demo.business.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
/**
 *
 * @author Adouche Ali
 */
@Entity
public class WebOrder implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    
    @ManyToMany
    private List<Livre> livres;

    @ManyToOne
    private EtatCommande etatCommande;
    
    public WebOrder() {
        System.out.println("creation order");
         etatCommande = new EtatCommande(EnumEtatCommande.ECV);
    }

    public WebOrder(Customer customer, List<Livre> livres) {
        this();
        this.customer = customer;
        this.livres = livres;
    }
  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public EtatCommande getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(EtatCommande etatCommande) {
        this.etatCommande = etatCommande;
    }

    @Override
    public String toString() {
        return "WebOrder{" + "id=" + id + ", customer=" + customer + ", livres=" + livres + ", etatCommande=" + etatCommande + '}';
    }
    
    
    
}
