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
//Dans cette classe on attribue le code mneumonique de chaque institution
public class Institution extends Proprietaire{
    private String libelle;
    private String couleur;
    private String Mneumonique;

    //est le constructeur
    public Institution(String adres, String adresMail, String libelle) {
        super(adres, adresMail);
        this.libelle = libelle;
        switch(libelle){
            case "corps diplomatique":
                Mneumonique = "CD";
                break;
            case "corps consulaire":
                Mneumonique = "CC";
                break;
            case "militaire":
                Mneumonique = "FARDC";
                break;
            case "police":
                Mneumonique = "PNC";
                break;
            case "professeur":
                Mneumonique = "PROF";
                break;
            case "agent cadre":
                Mneumonique = "AG";
                break;
            case "haut fonctionnaire":
                Mneumonique = "HFONC";
                break;
            case "présidence":
                Mneumonique = "PR";
                break;
            case "ministère":
                Mneumonique = "MIN";
                break;
            case "gouvernorat":
                Mneumonique = "GOUV";
                break;
            case "communal":
                Mneumonique = "COM";
                break;
            case "territorial":
                Mneumonique = "TER";
                break;
            case "onu":
                Mneumonique = "UN";
                break;
            case "monuc":
                Mneumonique = "UN";
                break;
            case "eusec":
                Mneumonique = "EUSEC";
                break;
            case "eupol":
                Mneumonique = "EUPOL";
                break;
            case "temporel":
                Mneumonique = "IT";
                break;
            case "assemblée nationale":
                Mneumonique = "AA";
                break;
            case "sénat":
                Mneumonique = "ASEN";
                break;
            case "justice":
                Mneumonique = "JUS";
                break;
            default:
                Mneumonique = "";
                break;
        }
    }

    //retourne le code mneumonique d'une institution
    public String NumeroFormation(){
        return Mneumonique;
    }

    
}
