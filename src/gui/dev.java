/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Mega-PC
 */
public class dev {

    
    //var

    private int id;
    private String fullname;
    private String grpname;
    private String mail;
    private String gender;
    
   
    
    //Constructor
    public dev() {
    }

    public dev(int id, String fullname, String grpname, String mail, String gender) {
        this.id = id;
        this.fullname = fullname;
        this.grpname = grpname;
        this.mail = mail;
        this.gender = gender;
      
    }

    public dev( String fullname, String grpname, String mail, String gender) {
     
        this.fullname = fullname;
        this.grpname = grpname;
        this.mail = mail;
        this.gender = gender;
    }

   
   


    
    
    //Getters & Setters
    public int getid() {
        return id;
    }

    public String getfullname() {
        return fullname;
    }

    public String getgrpname() { 
        return grpname;
    }

    public String getmail() {
        return mail;
    }

    public String getgender() {
        return gender;
    }

   

   

    public void setid(int id) {
        this.id = id;
    }

    public void setfullname(String fullname) {
        this.fullname = fullname;
    }

    public void setgrpname(String grpname) {
        this.grpname = grpname;
    }

    public void setmail(String mail) {
        this.mail = mail;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    
    

    //Affichage
    @Override
    public String toString() {
        return "dev{" + "id=" + id + ", fullname=" + fullname + ", grpname=" + grpname+ ", mail=" + mail + ", gender=" + gender  + "}";
    }

   
}
   