/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class Manager extends Personne {
   private List<Personne> developpeurs;

    public Manager() {
    }

    public Manager(int id, String nom, double salaire) {
        super(id, nom, salaire);
        this.developpeurs = new ArrayList<>();
    }

    public List<Personne> getDeveloppeurs() {
        return developpeurs;
    }

    public void setDeveloppeurs(List<Personne> developpeurs) {
        this.developpeurs = developpeurs;
    }

    @Override
    public String toString() {
        return "Manager" + super.toString() ;
    }

    public void ajouterDeveloppeur(Personne developpeur) {
        developpeurs.add(developpeur); 
    }
    public List <Personne> getDeveloppeur(){
        return developpeurs;
    }
    
}
