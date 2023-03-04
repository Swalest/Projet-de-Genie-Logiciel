/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MOBOTINUMERO;

//Importation des bibliothèques
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SWALEST
 */
public class DBConnexion {
    Connection connecter;
    Statement stat;
    String url;
    String userName;
    String motPasse;
    /*try{
        Class.ForName("com.mysql.jdbc.Driver");
    }
    catch(ClassNotFoundException e){
        System.err.println(e);
    }*/
    public DBConnexion(String serevere, String utilisateur, String mot, int poro, String baze){
        this.url = "jdbc:mysql://" + serevere + ":" + Integer.toString(poro) + "/" + baze + "?ServerTimezone = UTC";
        this.userName = utilisateur;
        this.motPasse = mot;
        try{
            connecter = DriverManager.getConnection(url, userName, mot);
            stat = connecter.createStatement();
        }catch(SQLException ex){
            Logger.getLogger(DBConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
        
    }
    public DBConnexion(String baze){
        this.url = "jdbc:mysql://localhost:3306/" + baze + "?ServerTimezone = UTC";
        this.userName = "root";
        this.motPasse = "";
        try{
            connecter = DriverManager.getConnection(url, userName, motPasse);
            stat = connecter.createStatement();
        }catch(SQLException e){
            System.err.println(e);
            Logger.getLogger(DBConnexion.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    public void DBRequetum(String requete) throws SQLException{
        stat.executeQuery(requete);
    }
    public void DBRequeta(String requete, String parametre) throws SQLException{
        
    }
    public ResultSet DBRecupum(String requete) throws SQLException{
        ResultSet resultat = stat.executeQuery(requete);
        return resultat;
    }
    public ResultSet DBRecupa(String requete, String parametre) throws SQLException{
        ResultSet resultat = stat.executeQuery(requete);
        return resultat;
    }
    
}
