/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package MOBOTINUMERO;

//Importation des bibliothèques

import static MOBOTINUMERO.SystemeMobotiNumero.jTableVoiture;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author SWALEST
 */
public class MOBOTINUMERO {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        
        //Déclaration des variables
        DBConnexion baseDonnee;
        Connection connectarium;
        baseDonnee = new DBConnexion("mysql");

        
        //Gestion de progressbar
        int nombre;
        Lancement Lancer = new Lancement();
        SystemeMobotiNumero App = new SystemeMobotiNumero();
        Lancer.setVisible(true);
        SystemeMobotiNumero.jRadioPersonne.setSelected(true);
        try{
            for(nombre = 0; nombre <= 100; nombre++){
                Thread.sleep(100);
                if(nombre <= 100){
                    Lancement.Pourcentage.setText(Integer.toString(nombre) + "%");
                    Lancement.Chargement.setValue(nombre);
                    nombre++;
                    Thread.sleep(100);
                } 
            }
            if(nombre >= 100){
                App.setVisible(true);
                Lancer.setVisible(false);
            }
            
        }
        catch(InterruptedException e){
            System.err.println(e);
        }
        //Etablissement de la connexion avec la base de données
        
        try{
            baseDonnee = new DBConnexion("ParcVoiture");
            try {
            App.AfficherVoiture();
            
        }catch(Exception e){
            System.err.println("Erreur: " + e);
        }
            
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "L\'erreur " + e + " est survenues lors de l'établissement de la connexion", "Erreur", 0);
        } 
    }
}
