/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.demo.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adouche Ali
 */
@Entity
@XmlRootElement
public class Livre implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private String editeur;
    private Double prix;

    public Livre() {
    }

    public Livre(String titre, String auteur, String editeur, Double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", prix=" + prix + '}';
    }
    
    
    
}
