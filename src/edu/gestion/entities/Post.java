package edu.gestion.entities;

import java.sql.Date;
import java.util.Calendar;

public class Post {

    int id_post;
    String titre;
    String auteur;
    String img_post;
    Date date_post;
    Calendar calendar = Calendar.getInstance();
    static int test;
    int rate;
    String image;
     String imag;

    public static int getTest() {
        return test;
    }

    public static void setTest(int test) {
        Post.test = test;
    }
    

    public Post(int id_post, String titre, String auteur, String img_post,String image) {
        this.id_post = id_post;
        this.titre = titre;
        this.auteur = auteur;
        this.img_post = img_post;
        this.date_post = new Date(calendar.getTime().getTime());
        this.image= image;
    }

    public Post(String titre, String auteur, String img_post,String image) {
        this.titre = titre;
        this.auteur = auteur;
        this.img_post = img_post;
        this.date_post = new Date(calendar.getTime().getTime());
        this.image= image;
    }

    public Post(int id_post, String titre, String auteur, String img_post, Date date_post,int rate,String image) {
        this.id_post = id_post;
        this.titre = titre;
        this.auteur = auteur;
        this.img_post = img_post;
        this.date_post = date_post;
        this.rate=rate;
        this.image= image;
    }
    
    public Post(int id_post, String titre, String img_post) {
        this.id_post = id_post;
        this.titre = titre;
        
        this.img_post = img_post;
        
    }
    public Post( String titre) {
        
        this.titre = titre;
        
    }
    public Post(int rate) {
        
        
        
        this.rate=rate;
        
    }
    
     

    public Post(String titre, String auteur, String img_post, Date date_post) {
        this.titre = titre;
        this.auteur = auteur;
        this.img_post = img_post;
        this.date_post = date_post;
    }

   

    public Post() {
        
    }

    

    public int getId_post() {
        return id_post;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getImg_post() {
        return img_post;
    }

    public Date getDate_post() {
        return date_post;

    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setImg_post(String img_post) {
        this.img_post = img_post;
    }

    public void setDate_post(Date date_post) {
        this.date_post = date_post;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
     public void setImag(String imag) {
        this.imag = imag;
    }
    

    @Override
    public String toString() {
        return "Post{" + "id_post=" + id_post + ", titre=" + titre + ", auteur=" + auteur + ", img_post=" + img_post + ", date_post=" + date_post  +", rate=" + rate  +",image"+image+ '}';
    }

    

}
