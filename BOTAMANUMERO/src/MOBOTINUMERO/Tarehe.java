/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MOBOTINUMERO;

import java.time.*;

/**
 *
 * @author SWALEST
 */
/*
Cette classe  génère la date actuelle en format nom du jour de la semaine, le jour nom du mois année
*/
public class Tarehe {
    private LocalDate todaysDate;
    
    //constructeur des objets
    public Tarehe(){
        //Récupération du jour en cours
        this.todaysDate = LocalDate.now();
    }
    public String TareheYaLeo(){
        
        //Récupération de jour du mois
        int jour = todaysDate.getDayOfMonth();
         //Récupération de l'année en cours
        int mwaka = todaysDate.getYear();
        String leo = SikuYaJuma() + ", le " + jour + " " + MweziYaMwaka() + " " + mwaka;
        return leo;
    }
    
    //C'est la méthode de la traduction de nom des jours de la semaine en français
    private String SikuYaJuma(){
        String juma = "";
        DayOfWeek dateJour = todaysDate.getDayOfWeek();
        if(DayOfWeek.MONDAY.equals(dateJour)){
            juma = "Lundi";
        }
        else if(DayOfWeek.TUESDAY.equals(dateJour)){
            juma = "Mardi";
        }
        else if(DayOfWeek.WEDNESDAY.equals(dateJour)){
            juma = "Mercredi";
        }
        else if(DayOfWeek.THURSDAY.equals(dateJour)){
            juma = "Jeudi";
        }
        else if(DayOfWeek.FRIDAY.equals(dateJour)){
            juma = "Vendredi";
        }
        else if(DayOfWeek.SATURDAY.equals(dateJour)){
            juma = "Samedi";
        }
        else if(DayOfWeek.SUNDAY.equals(dateJour)){
            juma = "Dimanche";
        }
        return juma;
    }
    
    //Cette méthode traduit le nom des mois en français
    private String MweziYaMwaka(){
        Month mois = todaysDate.getMonth();
        String mwezi = "";
        if(Month.JANUARY.equals(mois)){
            mwezi = "Janvier";
        }
        else if(Month.FEBRUARY.equals(mois)){
            mwezi = "Février";
        }
        else if(Month.MARCH.equals(mois)){
            mwezi = "Mars";
        }
        else if(Month.APRIL.equals(mois)){
            mwezi = "Avril";
        }
        else if(Month.MAY.equals(mois)){
            mwezi = "Mai";
        }
        else if(Month.JUNE.equals(mois)){
            mwezi = "Juin";
        }
        else if(Month.JULY.equals(mois)){
            mwezi = "Juillet";
        }
        else if(Month.AUGUST.equals(mois)){
            mwezi = "Août";
        }
        else if(Month.SEPTEMBER.equals(mois)){
            mwezi = "Septembre";
        }
        else if(Month.OCTOBER.equals(mois)){
            mwezi = "Octobre";
        }
        else if(Month.NOVEMBER.equals(mois)){
            mwezi = "Novembre";
        }
        else if(Month.DECEMBER.equals(mois)){
            mwezi = "Décembre";
        }
        return mwezi;
    }
    
}
