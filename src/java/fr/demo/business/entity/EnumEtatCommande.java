package fr.demo.business.entity;

/**
 *
 * @author Adouche Ali
 */
public enum EnumEtatCommande {
    
    
    ECV("En cours de validation"),
    VA("Validée"),
    ECL("En cours de livraison"),
    CL("Cloturée");
    
    private final String nom; 

    private EnumEtatCommande(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
     public EnumEtatCommande next() {
        int indice = this.ordinal() + 1;

        switch (indice) {
            case 1:
                return EnumEtatCommande.VA;
            case 2:
                return EnumEtatCommande.ECL;
            case 3:
                return EnumEtatCommande.CL;
            default:
                return this;
        }
    }
    
    
    
}
