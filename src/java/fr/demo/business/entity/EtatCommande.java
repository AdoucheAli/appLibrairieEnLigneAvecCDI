package fr.demo.business.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Adouche Ali
 */
@Entity
@NamedQueries({@NamedQuery(name = EtatCommande.BY_CODE,query = "select ec from EtatCommande ec where ec.code = :code")})
public class EtatCommande implements Serializable {
    
    public final static String PREFIXE = "fr.demo.business.entity."; 
    public final static String BY_CODE = PREFIXE + "EtatCommande.findByCode"; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  
    @OneToMany(mappedBy="etatCommande")
    @Enumerated(EnumType.STRING)
    private EnumEtatCommande code;

    private String valeurCode;
    

    public EtatCommande() {
    }

    public EtatCommande(EnumEtatCommande code) {
        setCode(code);
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumEtatCommande getCode() {
        return code;
    }

    public void setCode(EnumEtatCommande code) {
        this.code = code;
        this.valeurCode = this.code.getNom();
    }
    
    
}
