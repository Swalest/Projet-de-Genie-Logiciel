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
public class Province {
    String nom;
    String codeMneumonique;
    public Province(String provNom){
        this.nom = provNom;
        switch(nom){
            case "bas-uele":
                codeMneumonique = "03";
                break;
            case "equateur":
                codeMneumonique = "04";
                break;
            case "haut-katanga":
                codeMneumonique = "02";
                break;
            case "haut-lomani":
                codeMneumonique = "05";
                break;
            case "haut-uele":
                codeMneumonique = "06";
                break;
            case "ituri":
                codeMneumonique = "07";
                break;
            case "kasaï":
                codeMneumonique = "08";
                break;
            case "kasaï central":
                codeMneumonique = "09";
                break;
            case "kasaï oriental":
                codeMneumonique = "10";
                break;
            case "kinshasa":
                codeMneumonique = "01";
                break;
            case "kongo-central":
                codeMneumonique = "11";
                break;
            case "kwango":
                codeMneumonique = "12";
                break;
            case "kwilu":
                codeMneumonique = "13";
                break;
            case "lomami":
                codeMneumonique = "14";
                break;
            case "lualaba":
                codeMneumonique = "15";
                break;
            case "mai-ndombe":
                codeMneumonique = "16";
                break;
            case "maniema":
                codeMneumonique = "17";
                break;
            case "mongala":
                codeMneumonique = "18";
                break;
            case "nord-kivu":
                codeMneumonique = "19";
                break;
            case "nord-ubangi":
                codeMneumonique = "20";
                break;
            case "sankuru":
                codeMneumonique = "21";
                break;
            case "sud-kivu":
                codeMneumonique = "22";
                break;
            case "sud-ubangi":
                codeMneumonique = "23";
                break;
            case "tanganyika":
                codeMneumonique = "24";
                break;
            case "tshopo":
                codeMneumonique = "25";
                break;
            case "tshuapa":
                codeMneumonique = "26";
                break;
            case "03":
                codeMneumonique = "Bas-Uele";
                break;
            case "04":
                codeMneumonique = "Equateur";
                break;
            case "02":
                codeMneumonique = "Haut-Katanga";
                break;
            case "05":
                codeMneumonique = "Haut-Lomani";
                break;
            case "06":
                codeMneumonique = "Haut-Uele";
                break;
            case "07":
                codeMneumonique = "Ituri";
                break;
            case "08":
                codeMneumonique = "Kasaï";
                break;
            case "09":
                codeMneumonique = "Kasaï Central";
                break;
            case "10":
                codeMneumonique = "Kasaï Oriental";
                break;
            case "01":
                codeMneumonique = "Kinshasa";
                break;
            case "11":
                codeMneumonique = "Kongo-Central";
                break;
            case "12":
                codeMneumonique = "Kwango";
                break;
            case "13":
                codeMneumonique = "Kwilu";
                break;
            case "14":
                codeMneumonique = "Lomami";
                break;
            case "15":
                codeMneumonique = "Lualaba";
                break;
            case "16":
                codeMneumonique = "Mai-Ndombe";
                break;
            case "17":
                codeMneumonique = "Maniema";
                break;
            case "18":
                codeMneumonique = "Mongala";
                break;
            case "19":
                codeMneumonique = "Nord-Kivu";
                break;
            case "20":
                codeMneumonique = "Nord-Ubangi";
                break;
            case "21":
                codeMneumonique = "Sankuru";
                break;
            case "22":
                codeMneumonique = "Sud-Kivu";
                break;
            case "23":
                codeMneumonique = "Sud-Ubangi";
                break;
            case "24":
                codeMneumonique = "Tanganyika";
                break;
            case "25":
                codeMneumonique = "Tshopo";
                break;
            case "26":
                codeMneumonique = "Tshuapa";
                break;
            default:
                codeMneumonique = "";
                break;
        }
    }
    public String getMneumoniqueProv(){
        return codeMneumonique;
    }
    
}
