/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.beans.Developpeur;
import ma.projet.beans.Manager;
import ma.projet.beans.Personne;
import ma.projet.service.DeveloppeurService;
import ma.projet.service.ManagerService;

/**
 *
 * @author hp
 */
public class Entreprise {
    public static void main(String[] args) {
       // Créer deux développeurs
        DeveloppeurService es  = new DeveloppeurService();
        Developpeur Dev1 = new Developpeur(1, "Dev1", 8000);
        Developpeur Dev2 = new Developpeur(2, "Dev2", 8700);
        Developpeur Dev3 = new Developpeur(3, "Dev3", 8500);
      
        es.create(Dev1);
        es.create(Dev2);
//        
        // Créer manager qui gère les deux premiers développeurs s crées précédemment 
        Manager manager1 = new Manager(4, "manager", 10000);
        manager1.ajouterDeveloppeur(Dev1);
        manager1.ajouterDeveloppeur(Dev2);
//       
       //Créer un troisième développeur
         es.create(Dev3);

//       //Créer un directeur général qui gère le manager et le troisième développeur
        Manager directeurGeneral = new Manager(5, "Directeur Général", 20000);
        directeurGeneral.ajouterDeveloppeur(manager1); 
        directeurGeneral.ajouterDeveloppeur(Dev3);    

       //Afficher les noms et les salaires des employés de haut en bas de la hiérarchie.
         afficherHierarchie(directeurGeneral, 0);
    }

   private static void afficherHierarchie(Personne p, int niveau) {
        String indent = "";
        for (int i = 0; i < niveau; i++) {
            indent += "  ";
        }
        System.out.println(indent + p.getNom() + " "  + " ==> Salaire: " + p.getSalaire());
        if (p instanceof Manager) {
            Manager m = (Manager) p;
            for (int i = 0; i < m.getDeveloppeur().size(); i++) {
                Personne subordonne = m.getDeveloppeur().get(i);
                afficherHierarchie(subordonne, niveau + 1);
            }
        }
    }
   
}

