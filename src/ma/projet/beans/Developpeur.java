/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

/**
 *
 * @author hp
 */
public class Developpeur extends Personne {

    public Developpeur() {
    }

    public Developpeur(int id, String nom, double salaire) {
        super(id, nom, salaire);
    }

    @Override
    public String toString() {
        return "Developpeur" + super.toString() ;
    }
    
    
}
