package edu.gestion.services;

import edu.gestion.entities.Comentaire;
import edu.gestion.utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComentaireCrud {

    private Connection con;
    private Statement ste;

    public ComentaireCrud() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Comentaire c) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO commentaire (nom_com,descri,date_com,id_post)VALUES (?,?,?,?)");
        pre.setString(1, c.getNom_com());
        pre.setString(2, c.getDesc_com());
        pre.setDate(3, c.getDate_com());
        pre.setInt(4, c.getId_post());
        

        pre.executeUpdate();
    }

    public boolean Update(int id_com, String nom_com, String descri_com, Date date_com, int id_post) {
        try {
            PreparedStatement pre = con.prepareStatement("update commentaire set nom_com =? , descri=?,date_com=?,id_post=? where id_com=? ;");

            pre.setInt(5, id_com);
            pre.setString(1, nom_com);
            pre.setString(2, descri_com);
            pre.setDate(3, date_com);
            pre.setInt(4, id_post);

            if (pre.executeUpdate() != 0) {
                System.out.println(" commantaire updated");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id  not found!!!");
        return false;
    }

    public boolean delete(Comentaire a){
        Connection cnx =null;
        Statement st = null;
        String requette = "DELETE FROM commentaire WHERE id_com="+a.getId_com()+"";
        try {
     cnx = DataBase.getInstance().getConnection();          
            st = cnx.createStatement();
            st.executeUpdate(requette);
            return true;
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally {
    
    if (st != null) {
        try {
            st.close();
        } catch (SQLException e) { /* Ignored */}
    }
        }}

    public List<Comentaire> readAll() throws SQLException {

        List<Comentaire> lu = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id_com ,nom_com,descri_com,date_com,id_post  from commentaire");
        while (rs.next()) {
            int id_com = rs.getInt("id_com");
            String nom_com = rs.getString("nom_com");
            String descri_com = rs.getString("descri_com");
//            Date date_com = rs.getDate("date_com");
            int id_post = rs.getInt("id_post");

            Comentaire c = new Comentaire(id_com, nom_com, descri_com, id_post);
            lu.add(c);
        }
        return lu;
    }

   public List<Comentaire> postCommentaire() throws SQLException {

        List<Comentaire> lu = new ArrayList<>();
        ste = con.createStatement();
        
        ResultSet rs = ste.executeQuery("SELECT commentaire.id_com,commentaire.nom_com,commentaire.descri,commentaire.date_com,commentaire.id_post,post.titre from commentaire INNER JOIN post ON commentaire.id_post=post.id_post;");
        while (rs.next()) {
            
          int id_com = rs.getInt("commentaire.id_com");
            String nom_com = rs.getString("commentaire.nom_com");
            String descri_com = rs.getString("commentaire.descri");
            Date date_com = rs.getDate("commentaire.date_com");
            int id_post = rs.getInt("commentaire.id_post");
            String titre_post = rs.getString("titre");
            

            Comentaire c = new Comentaire(id_com,nom_com,descri_com,date_com,id_post,titre_post);
            
            lu.add(c);
        }
        return lu;
    }
   public List<Comentaire> readAll1() throws SQLException {

        List<Comentaire> lu = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id_com ,nom_com,descri_com,date_com,id_post  from commentaire");
        while (rs.next()) {
            int id_com = rs.getInt("id_com");
            String nom_com = rs.getString("nom_com");
            String descri_com = rs.getString("descri_com");
//            Date date_com = rs.getDate("date_com");
            int id_post = rs.getInt("id_post");

            Comentaire c = new Comentaire( nom_com, descri_com);
            lu.add(c);
        }
        return lu;
    }
   public List<Comentaire> postCommentaires(int id_poste) throws SQLException {

        List<Comentaire> lu = new ArrayList<>();
        ste = con.createStatement();
        
        ResultSet rs = ste.executeQuery("SELECT * from commentaire WHERE id_post="+id_poste+";");
        while (rs.next()) {
            
          int id_com = rs.getInt("commentaire.id_com");
            String nom_com = rs.getString("commentaire.nom_com");
            String descri_com = rs.getString("commentaire.descri");
        
            int id_post = rs.getInt("commentaire.id_post");
            
            

            Comentaire c = new Comentaire(id_com,nom_com,descri_com,id_post);
            
            lu.add(c);
        }
        return lu;
    }
   
   

}
