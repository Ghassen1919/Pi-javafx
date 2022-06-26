package edu.gestion.entities;

import java.sql.Date;
import java.util.Calendar;

public class Reclamation {

    int id_réc;
    String nom_réc;
    Date date_réc;
    Calendar calendar = Calendar.getInstance();
    String descri_réc;
    String traite ;
    

    public Reclamation(int id_réc, String nom_réc, String descri_réc, Date date_réc,String traite) {
        this.id_réc = id_réc;
        this.nom_réc = nom_réc;
        this.date_réc = date_réc;
        this.descri_réc = descri_réc;
        this.traite=traite ;
        

    }

    public Reclamation(String nom_réc, String descri_réc, Date date_réc ,String traite) {
        this.nom_réc = nom_réc;
        this.date_réc = date_réc;
        this.descri_réc = descri_réc;
        this.traite=traite ;
    }
    public Reclamation(int id_réc ,String nom_réc, String descri_réc,String traite) {
        this.id_réc = id_réc; 
        this.nom_réc = nom_réc;
       
        this.date_réc = new Date(calendar.getTime().getTime());
        this.descri_réc = descri_réc;
        this.traite=traite ;
    }
    public Reclamation(int id_réc, String nom_réc, String descri_réc) {
        this.id_réc = id_réc;
        this.nom_réc = nom_réc;
        this.date_réc = new Date(calendar.getTime().getTime());
        this.descri_réc = descri_réc;
        

    }

    public Reclamation(String nom_réc, String descri_réc) {
        this.nom_réc = nom_réc;
        this.date_réc = new Date(calendar.getTime().getTime());
        this.descri_réc = descri_réc;
    }
    public Reclamation( String descri_réc) {
        this.nom_réc = "Mouna";
        this.date_réc = new Date(calendar.getTime().getTime());
        this.descri_réc = descri_réc;
    }

    public int getId_réc() {
        return id_réc;
    }

    public void setId_réc(int id_réc) {
        this.id_réc = id_réc;
    }

    public String getNom_réc() {
        return nom_réc;
    }
    public String getTraite() {
        return traite;
    }

    public void setNom_réc(String nom_réc) {
        this.nom_réc = nom_réc;
    }

    public Date getDate_réc() {
        return date_réc;
    }

    public void setDate_réc(Date date_réc) {
        this.date_réc = date_réc;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getDescri_réc() {
        return descri_réc;
    }

    public void setDescri_réc(String descri_réc) {
        this.descri_réc = descri_réc;
    }
    
    public void setTraite(String traite) {
        this.traite = traite;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_r\u00e9c=" + id_réc + ", nom_r\u00e9c=" + nom_réc + ", date_r\u00e9c=" + date_réc + ", calendar=" + calendar + ", descri_r\u00e9c=" + descri_réc +",traite"+traite+ '}';
    }
    
    
 

}
