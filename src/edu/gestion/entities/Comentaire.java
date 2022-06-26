package edu.gestion.entities;

import java.sql.Date;
import java.util.Calendar;

public class Comentaire {

    int id_com;
    String nom_com;
    String descri_com;
    int id_post;
    String titre_post;
    Date date_com;
   
    Calendar calendar = Calendar.getInstance();

    public Comentaire(int id_com, String nom_com, String descri_com, int id_post) {
        this.id_com = id_com;
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = new Date(calendar.getTime().getTime());
        this.id_post = id_post;
       
    }
    public Comentaire(int id_com, String nom_com, String descri_com,Date date_com, int id_post,String titre_post) {
        this.id_com = id_com;
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = date_com;
        this.id_post = id_post;
        this.titre_post = titre_post;
        
       
    }

    public Comentaire( String descri_com, int id_post ) {
        this.nom_com ="Mouna";
        this.descri_com = descri_com;
        this.date_com = new Date(calendar.getTime().getTime());
        this.id_post = id_post;
        
        
    }
    public Comentaire(String nom_com, String descri_com,int id_post ,String titre_post) {
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = new Date(calendar.getTime().getTime());
         this.titre_post = titre_post;
         this.id_post = id_post;

        
        
        
    }

    public Comentaire(int id_com, String nom_com, String descri_com, Date date_com, int id_post) {
        this.id_com = id_com;
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = date_com;
        this.id_post = id_post;
    }

    public Comentaire(String nom_com, String descri_com, Date date_com, int id_post) {
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = date_com;
        this.id_post = id_post;
    }

    public Comentaire(String nom_com, String titre_post) {

        this.nom_com = nom_com;
        this.titre_post = titre_post;
    }

    public Comentaire(int id_com,String nom_com, String descri_com, String titre_post) {
        this.id_com = id_com;
        this.nom_com = nom_com;
        this.descri_com = descri_com;
        this.date_com = new Date(calendar.getTime().getTime());
        this.titre_post = titre_post;
    }

    

    public int getId_com() {
        return id_com;
    }

    public String getNom_com() {
        return nom_com;
    }

    public String getDesc_com() {
        return descri_com;
    }

    public Date getDate_com() {
        return date_com;

    }

    public int getId_post() {
        return id_post;
    }

    public String getDescri_com() {
        return descri_com;
    }

    public void setDescri_com(String descri_com) {
        this.descri_com = descri_com;
    }

    public String getTitre_post() {
        return titre_post;
    }

    public void setTitre_post(String titre_post) {
        this.titre_post = titre_post;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public void setNom_com(String nom_com) {
        this.nom_com = nom_com;
    }

    public void setDesc_com(String descri_com) {
        this.descri_com = descri_com;
    }

    public void setDate_réc(Date date_com) {
        this.date_com = date_com;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

        @Override
        public String toString() {
            return "Comentaire{" + "id_com=" + id_com + ", nom_com=" + nom_com + ", descri_com=" + descri_com + ", id_post=" + id_post + ", titre_post=" + titre_post + ", date_com=" + date_com + /*", calendar=" + calendar + */'}';
    }

    

}
