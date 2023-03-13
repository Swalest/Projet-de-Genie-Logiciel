/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MOBOTINUMERO;

import java.util.Random;

/**
 *
 * @author SWALEST
 */
public class FormationNumero {
    String aleaNumero;
    Random aleatoire;
    int nombre;
    String numero;
    String province;
    String proprietaire;
    Province Prov;
    
    //La méthode de la génération de numero constitué de trois chiffres suivis de quatre lettre
    public String GenererNumero(){
        aleatoire = new Random();
         nombre = aleatoire.nextInt(10);
        aleaNumero = Integer.toString(nombre);
        do{
           aleatoire = new Random();
           nombre = aleatoire.nextInt(10);
            aleaNumero += Integer.toString(nombre); 
        }while(aleaNumero.length() < 3);
        do{
            String varia;
            aleatoire = new Random();
            nombre = 65 + aleatoire.nextInt(91 - 65);
            while(nombre == 73 || nombre == 79){
                aleatoire = new Random();
                nombre = 65 + aleatoire.nextInt(91 - 65);
            }
            varia = Character.toString((char)nombre);
            aleaNumero += varia; 
        }while(aleaNumero.length() < 7);
        return aleaNumero;
    }
    
    //La méthode de la formation de numero en y ajoutant les caractères supplémentaires
    public String[] FormerNumero(String propri, String prov, String num, String adre, String mahile){
        this.province = prov;
        this.proprietaire = propri;
        String codeMneumo;
        String codeProv = "";
        Prov = new Province(province);
        codeProv = Prov.getMneumoniqueProv();
        this.numero = num;
        if("personne".equals(proprietaire)){
            String [] valeurRetour = {numero, codeProv, ""};
            return valeurRetour;
        }
        else{
            codeMneumo = new Institution(adre, mahile, proprietaire).NumeroFormation();
            String [] valeurRetour = {numero, codeProv, codeMneumo};
            return valeurRetour;
        }
    }
}
