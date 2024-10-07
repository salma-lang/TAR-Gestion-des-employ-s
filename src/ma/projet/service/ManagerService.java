/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Manager;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

/**
 *
 * @author hp
 */
public class ManagerService implements  IDao<Manager>{

    @Override
    public boolean create(Manager o) {
          boolean r = false;
        try {
            String req = "INSERT INTO `manager` (`id`, `nom`, `salaire`) VALUES (?, ?, ?);";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, o.getId());
            st.setString(2, o.getNom());
            st.setDouble(3, o.getSalaire());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public boolean update(Manager o) {
        boolean r = false;
        try {
            String req = "UPDATE manager SET nom = ?, salaire = ? WHERE id = ?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, o.getId());
            st.setString(2, o.getNom());
            st.setDouble(3, o.getSalaire());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }  
        } catch (Exception ex) {
           Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public boolean delete(Manager o) {
         boolean r = false;
        try {
            String req = "DELETE FROM `manager` where id  = ?";
            PreparedStatement st = Connexion.getCn(). prepareStatement(req);
            st.setInt(1, o.getId());
            int n = st.executeUpdate();
            if (n == 1) {
                r = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public Manager getdById(int id) {
       try {
            String req = "select * from manager where id = ?";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Manager(rs.getInt("id"), rs.getString("nom"),rs.getDouble("salaire"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Manager> getAll() {
          List<Manager> managers = new ArrayList<>();
        try {
            String req = "select * from manager";
            PreparedStatement st = Connexion.getCn().prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                managers.add(new Manager(rs.getInt("id"), rs.getString("nom"), rs.getDouble("salaire")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return managers;
    }
    
}
