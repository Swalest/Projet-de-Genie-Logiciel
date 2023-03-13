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
//La classe de l'établissement de la connexion avec la base de données'
public class DBConnexion {
    public Connection connecter;
    public Statement stat;
    public PreparedStatement preStat;
    String url;
    String userName;
    String motPasse;
    /*
    Le constructeur nécessitant la connaissance du serveur, du nom de l'utilisateur, 
    de son mot de passe, de port utilisé et de nom de la base de donnée
    */
    public DBConnexion(String serevere, String utilisateur, String mot, int poro, String baze) throws SQLException{
        this.url = "jdbc:mysql://" + serevere + ":" + Integer.toString(poro) + "/" + baze + "?ServerTimezone = UTC";
        this.userName = utilisateur;
        this.motPasse = mot;
        Charger();
        try{
            //Etablissement de la connexion avec la base de donnée passée en parametre
            connecter = DriverManager.getConnection(url, userName, motPasse);
        }catch(SQLException ex){
            Logger.getLogger(DBConnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
            connecter.close();
        }
        
    }
    //Le constructeur lors que l'on connait que le nom de la base de donnée;
    public DBConnexion(String baze) throws SQLException{
        this.url = "jdbc:mysql://localhost:3306/" + baze + "?ServerTimezone = UTC";
        this.userName = "root";
        this.motPasse = "";
        Charger();
        try{
            //Etablissement de la connexion avec la base de donnée passée en parametre
            connecter = DriverManager.getConnection(this.url, this.userName, this.motPasse);
        }catch(SQLException e){
            System.out.println(e.getMessage());
            Logger.getLogger(DBConnexion.class.getName()).log(Level.SEVERE, null, e);
            connecter.close();
            }
    }
    //La méthode du chargement de pilote de SGBD MYSQL: JDBC.DRIVER
    private void Charger(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
    //La methode de retour de la connexion
    public Connection getConnexion(){
        return connecter;
    }
    
}
