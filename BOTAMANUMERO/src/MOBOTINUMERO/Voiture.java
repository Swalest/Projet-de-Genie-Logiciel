/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MOBOTINUMERO;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author SWALEST
 */
/*Cette classe est très importante pour ce dit projet.
C'est elle qui est chargée de:
--D'immatriculation des voitures
--Et des opérations pouvant s'appliquer à une voiture
*/
public class Voiture {
    private String numeroImat;
    private String numeroChassis;
    private String numeroSerie;
    private String numeroReception;
    private String CNIT;
    private String modele;
    private String marque;
    private String carburant;
    private int idPropri;
    private int idVoit;
    private Double poids;
    DBConnexion baseDonnee;
    PreparedStatement preStatit;
    Connection connectarium;
    Statement stat;
    ResultSet resultat;
    //le constructeur
    public Voiture(String Imat, String chassis, String serie, String reception, String CNIT, String modele, String marque, String carburant, Double poids) throws SQLException{
        this.baseDonnee = new DBConnexion("ParcVoiture");
        connectarium = baseDonnee.getConnexion();
        this.numeroImat = Imat;
        this.CNIT = CNIT;
        this.numeroChassis = chassis;
        this.numeroSerie = serie;
        this.numeroReception = reception;
        this.modele = modele;
        this.marque = marque;
        this.carburant = carburant;
        this.poids = poids;
    }
    //Immatriculation de voiture d'une personne
    public void ImmatriculationAvecPerso(String[] proprietaire, String[] perso) throws SQLException{
        int fin = numeroImat.length() - 3;
        String chaine = numeroImat.substring(0,fin);
        if(ComparerImmatricule(chaine) == true){
            JOptionPane.showMessageDialog(null, "Ce numéro est déjà attribué. Veuillez générer un autre numéro s'il vous plait", "Suggestion", 2);
        }
        else{
            preStatit = connectarium.prepareStatement("INSERT INTO `Proprietaire`(`ProprietaireAdresse`, `ProprietaireMail`) VALUES(?, ?)");
            preStatit.setString(1, proprietaire[0]);
            preStatit.setString(2, proprietaire[1]);
            preStatit.executeUpdate();
            stat = connectarium.createStatement();
            resultat = stat.executeQuery("SELECT MAX(`ProprietaireNumero`) FROM `Proprietaire`");
            while(resultat.next()){
                idPropri = resultat.getInt("MAX(`ProprietaireNumero`)");
                System.out.println(idPropri);
            }
            try{
                idPropri += 0;
            }catch(Exception e){
                idPropri = 1;
            }
            preStatit = connectarium.prepareStatement("INSERT INTO `Personne`(`PersonneNumero`, `PersonneNom`, `PersonnePrenom`, `PersonneSexe`, `PersonneFonction`) VALUES(?, ?, ?, ?, ?)");
            preStatit.setInt(1, idPropri);
            preStatit.setString(2, perso[0]);
            preStatit.setString(3, perso[1]);
            preStatit.setString(4, perso[2]);
            preStatit.setString(5, perso[3]);
            preStatit.executeUpdate();
            preStatit = connectarium.prepareStatement("INSERT INTO `Voiture`(`VoitureNumeroImmatriculation`, `VoitureNumero`, `VoitureNumeroReception`, `VoitureNumeroChassis`, `VoitureNumeroSerie`, `VoitureCNIT`, `VoitureModele`, `VoitureMarque`, `VoitureCarburant`, `VoiturePoids`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preStatit.setString(1, numeroImat);
            preStatit.setInt(2, idPropri);
            preStatit.setString(3, numeroReception);
            preStatit.setString(4, numeroChassis);
            preStatit.setString(5, numeroSerie);
            preStatit.setString(6, CNIT);
            preStatit.setString(7, modele);
            preStatit.setString(8, marque);
            preStatit.setString(9, carburant);
            preStatit.setDouble(10, poids);
            preStatit.executeUpdate();
        }
        connectarium.close();
    }
    //Immatriculation de voiture d'une institution
    public void ImmatriculationAvecInstit(String[] proprietaire, String[] instit) throws SQLException{
        int debut = numeroImat.length() - 10;
        int fin = numeroImat.length() - 3;
        String chaine = numeroImat.substring(debut,fin);
        if(ComparerImmatricule(chaine) == true){
            JOptionPane.showMessageDialog(null, "Ce numéro est déjà attribué Veuillez générer un autre numéro s'il vous plait", "Suggestion", 2);
        }
        else{
            preStatit = connectarium.prepareStatement("INSERT INTO `Proprietaire`(`ProprietaireAdresse`, `ProprietaireMail`) VALUES(?, ?)");
            preStatit.setString(1, proprietaire[0]);
            preStatit.setString(2, proprietaire[1]);
            preStatit.executeUpdate();
            stat = connectarium.createStatement();
            resultat = stat.executeQuery("SELECT MAX(`ProprietaireNumero`) FROM `Proprietaire`");
            while(resultat.next()){
                idPropri = resultat.getInt("MAX(`ProprietaireNumero`)");
                System.out.println(idPropri);
            }
            try{
                idPropri += 0;
            }catch(Exception e){
                idPropri = 1;
            }
            preStatit = connectarium.prepareStatement("INSERT INTO `Institution`(`InstitutionNumero`, `InstitutionLibelle`, `InstitutionMneumo`) VALUES (?, ?, ?)");
            preStatit.setInt(1, idPropri);
            preStatit.setString(2, instit[0]);
            preStatit.setString(3, instit[1]);
            preStatit.executeUpdate();
            preStatit = connectarium.prepareStatement("INSERT INTO `Voiture`(`VoitureNumeroImmatriculation`, `VoitureNumero`, `VoitureNumeroReception`, `VoitureNumeroChassis`, `VoitureNumeroSerie`, `VoitureCNIT`, `VoitureModele`, `VoitureMarque`, `VoitureCarburant`, `VoiturePoids`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preStatit.setString(1, numeroImat);
            preStatit.setInt(2, idPropri);
            preStatit.setString(3, numeroReception);
            preStatit.setString(4, numeroChassis);
            preStatit.setString(5, numeroSerie);
            preStatit.setString(6, CNIT);
            preStatit.setString(7, modele);
            preStatit.setString(8, marque);
            preStatit.setString(9, carburant);
            preStatit.setDouble(10, poids);
            preStatit.executeUpdate();
        }
        connectarium.close();
    }
    /*Si la voiture change la province de l'activité
    Cette méthode recoit en argument l'immatriculation et le nom du nouveau province
    et retourne un nouveau immatriculation qui sera conforme au nou province
    */
    private String Demenagement(String Immatricule, String nouveaupro){
        int debut = Immatricule.length() - 2;
        int fin = Immatricule.length();
        String chaine = Immatricule.substring(debut,fin);
        String provin = new Province(nouveaupro.toLowerCase()).getMneumoniqueProv();
        if("".equals(provin)){
            return Immatricule;
        }
        else{
            return chaine + provin;
        }
    }
    /*La méthode de la suppression d'une voiture
    Elle recoit en parametre le numéro d'immatriculation de la voiture et supprime ladite voiture
    */
    public void Usure(String Immatricule) throws SQLException{
        ResultSet numerop;
        int numeroPro = 0;
        preStatit = connectarium.prepareStatement("SELECT `VoitureNumero` FROM `Voiture` WHERE `VoitureNumeroImmatriculation` = ?");
        preStatit.setString(1, Immatricule);
        numerop = preStatit.executeQuery();
        preStatit = connectarium.prepareStatement("DELETE FROM `Voiture` WHERE `VoitureNumeroImmatriculation` = ?");
        preStatit.setString(1, Immatricule);
        preStatit.executeUpdate();
        while(numerop.next()){
            numeroPro = numerop.getInt("VoitureNumero");
        }
        try{
            preStatit = connectarium.prepareStatement("DELETE FROM `Personne` WHERE `PersonneNumero` = ?");
            preStatit.setInt(1, numeroPro);
            preStatit.executeUpdate();
        }catch(Exception exp){
            System.err.println("Erreur: " + exp);
        }
        try{
            preStatit = connectarium.prepareStatement("DELETE FROM `Institution` WHERE `InstitutionNumero` = ?");
            preStatit.setInt(1, numeroPro);
            preStatit.executeUpdate();
        }catch(Exception exp){
            System.err.println("Erreur: " + exp);
        }
        preStatit = connectarium.prepareStatement("DELETE FROM `Proprietaire` WHERE `ProprietaireNumero` = ?");
        preStatit.setInt(1, numeroPro);
        preStatit.executeUpdate();
        JOptionPane.showMessageDialog(null, "La suppression de cette voiture est effectuée avec succès", "Information", 1);
        connectarium.close();
    }
    
    /*
    Cette méthode interviendra lors de l'acquisition ou de la session d'une voiture ou de n'importe autre modification de la voiture et/ou de ses caractéristiques
    Elle recoit en argument le tableau propriétaire contenant l'adresse et le mail du propriétaire ainsi que la province où roule la voiture et
    le tableau contenant les information de l'institution
    Ici, il s'agit de la voiture d'une institution
    */
    public void ModificationAvecInstit(String[] proprietaire, String[] instit, int numeroId) throws SQLException{
        preStatit = connectarium.prepareStatement("UPDATE `Proprietaire`SET `ProprietaireAdresse` = ?, `ProprietaireMail` = ? WHERE `ProprietaireNumero` = ?");
        preStatit.setString(1, proprietaire[0]);
        preStatit.setString(2, proprietaire[1]);
        preStatit.setInt(3, numeroId);
        preStatit.executeUpdate();
        preStatit = connectarium.prepareStatement("UPDATE `Institution` SET `InstitutionLibelle` = ?, `InstitutionMneumo` = ? WHERE `InstitutionNumero` = ?");
        preStatit.setString(1, instit[0]);
        preStatit.setString(2, instit[1]);
        preStatit.setInt(3, numeroId);
        preStatit.executeUpdate();
        numeroImat = Demenagement(numeroImat, proprietaire[2]);
        preStatit = connectarium.prepareStatement("UPDATE `Voiture` SET `VoitureNumeroImmatriculation` = ?, `VoitureNumeroReception` = ?, `VoitureNumeroChassis` = ?, `VoitureNumeroSerie` = ?, `VoitureCNIT` = ?, `VoitureModele` = ?, `VoitureMarque` = ?, `VoitureCarburant` = ?, `VoiturePoids` = ? WHERE `VoitureNumero` = ?");
        preStatit.setString(1, numeroImat);
        preStatit.setString(2, numeroReception);
        preStatit.setString(3, numeroChassis);
        preStatit.setString(4, numeroSerie);
        preStatit.setString(5, CNIT);
        preStatit.setString(6, modele);
        preStatit.setString(7, marque);
        preStatit.setString(8, carburant);
        preStatit.setDouble(9, poids);
        preStatit.setInt(10, numeroId);
        preStatit.executeUpdate();
        JOptionPane.showMessageDialog(null, "La modification de cette voiture est effectuée avec succès", "Information", 1);
        connectarium.close();
    }
    
    /*
    Cette méthode interviendra lors de l'acquisition ou de la session d'une voiture ou de n'importe autre modification de la voiture et/ou de ses caractéristiques
    Elle recoit en argument le tableau propriétaire contenant l'adresse et le mail du propriétaire ainsi que la province où roule la voiture et
    le tableau contenant les information de l'institution. Il s'agit ici de la voiture d'une personne
    */
    public void ModificationAvecPerso(String[] proprietaire, String[] perso, int numeroId) throws SQLException{
        preStatit = connectarium.prepareStatement("UPDATE `Proprietaire`SET `ProprietaireAdresse` = ?, `ProprietaireMail` = ? WHERE `ProprietaireNumero` = ?");
        preStatit.setString(1, proprietaire[0]);
        preStatit.setString(2, proprietaire[1]);
        preStatit.setInt(3, numeroId);
        preStatit.executeUpdate();
        preStatit = connectarium.prepareStatement("UPDATE `Personne` SET `PersonneNom` = ?, `PersonnePrenom` = ?, `PersonneSexe` = ?, `PersonneFonction` = ? WHERE `PersonneNumero` = ?");
        preStatit.setString(1, perso[0]);
        preStatit.setString(2, perso[1]);
        preStatit.setString(3, perso[2]);
        preStatit.setString(4, perso[3]);
        preStatit.setInt(5, numeroId);
        preStatit.executeUpdate();
        numeroImat = Demenagement(numeroImat, proprietaire[2]);
        preStatit = connectarium.prepareStatement("UPDATE `Voiture` SET `VoitureNumeroImmatriculation` = ?, `VoitureNumeroReception` = ?, `VoitureNumeroChassis` = ?, `VoitureNumeroSerie` = ?, `VoitureCNIT` = ?, `VoitureModele` = ?, `VoitureMarque` = ?, `VoitureCarburant` = ?, `VoiturePoids` = ? WHERE `VoitureNumero` = ?");
        preStatit.setString(1, numeroImat);
        preStatit.setString(2, numeroReception);
        preStatit.setString(3, numeroChassis);
        preStatit.setString(4, numeroSerie);
        preStatit.setString(5, CNIT);
        preStatit.setString(6, modele);
        preStatit.setString(7, marque);
        preStatit.setString(8, carburant);
        preStatit.setDouble(9, poids);
        preStatit.setInt(10, numeroId);
        preStatit.executeUpdate();
        JOptionPane.showMessageDialog(null, "La modification de cette voiture est effectuée avec succès", "Information", 1);
        connectarium.close();
    }
    
    private void CertificatImmatriculation(String Immatricule) throws SQLException{
        
    }
    //La méthode de la vérification si un numéro d'immatriculation est déjà attribué
    private boolean ComparerImmatricule(String chaine) throws SQLException{
        boolean verifier = false;
        String verifIma;
        stat = connectarium.createStatement();
        resultat = stat.executeQuery("SELECT `VoitureNumeroImmatriculation` FROM `Voiture`");
        try{
            while(resultat.next()){
                verifIma = resultat.getString("VoitureNumeroImmatriculation");
                int debut = verifIma.length() - 10;
                int fin = verifIma.length() - 3;
                verifIma = verifIma.substring(debut,fin);
                if(verifIma.equals(chaine)){
                    verifier = true;
                    break;
                }
        }
        }catch(SQLException e){
            System.err.println("Erreur: " + e);
        }
        return verifier;
    }
    
}