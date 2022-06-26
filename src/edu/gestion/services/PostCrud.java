package edu.gestion.services;

import edu.gestion.entities.Post;
import edu.gestion.utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostCrud {

    private Connection con;
    private Statement ste;

    public PostCrud() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Post p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO post (titre,auteur,img_post,date_post,image1,image)VALUES (?,?,?,?,?,?);");
        pre.setString(1, p.getTitre());
        pre.setString(2, p.getAuteur());
        pre.setString(3, p.getImg_post());
        pre.setDate(4, p.getDate_post());
        pre.setString(5, p.getImage());
       pre.setString(6, p.getImage());
        pre.executeUpdate();
    }

    public boolean update(Post a){
        Connection cnx =null;
        Statement st = null;
        
        
        String requette = "UPDATE post SET titre='"+a.getTitre()+"',auteur='"+a.getAuteur()+"',img_post='"+a.getImg_post()+"',date_post='"+a.getDate_post()+"',image1='"+a.getImage()+"',image='"+a.getImage()+"' WHERE id_post="+a.getId_post()+"";
                     
        
        
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


     public boolean delete(Post a){
        Connection cnx =null;
        Statement st = null;
        String requette = "DELETE FROM post WHERE id_post="+a.getId_post()+"";
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
    }
        
    }
    

    

    public List<Post> readAll() throws SQLException {

        List<Post> lu = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id_post ,titre,auteur,img_post,date_post,rate,image1  from post");
        while (rs.next()) {
            int id_post = rs.getInt("id_post");
            String titre = rs.getString("titre");
            String auteur = rs.getString("auteur");
            String img_post = rs.getString("img_post");
           Date date_post = rs.getDate("date_post");
           int rate= rs.getInt("rate");
           String image = rs.getString("image1");
            Post p = new Post(id_post, titre, auteur, img_post,date_post,rate,image);
            lu.add(p);
        }
        return lu;
    }
    public boolean updaterate(int rate, int id_post) {
     try {
            PreparedStatement pre = con.prepareStatement("update post set  rate=?   where id_post=? ;");
            
           
            pre.setInt(1, rate);
           
          
            pre.setInt(2, id_post);

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
    

}
