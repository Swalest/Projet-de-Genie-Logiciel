/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MOBOTINUMERO;

/**
 *
 * @author SWALEST
 */
//Cette classe est la classe abstraite qui sera spécifiée à la classe Personne et à la classe Institution
public class Proprietaire {
    int numero;
    String adresse;
    String mail;
    //est le constructeur
    public Proprietaire(String adres, String adresMail){
        this.adresse = adres;
        this.mail = adresMail;
    }
    
}
