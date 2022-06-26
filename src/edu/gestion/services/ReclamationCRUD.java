package edu.gestion.services;

import edu.gestion.entities.Reclamation;
import edu.gestion.utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class ReclamationCRUD {

    private Connection con;
    private Statement ste;

    public ReclamationCRUD() {
        con = DataBase.getInstance().getConnection();

    }

    public void ajouter(Reclamation r) throws SQLException {

        PreparedStatement pre = con.prepareStatement("INSERT INTO `reclamation`(`nom_rec`, `date_rec`, `descri_rec`) VALUES (?,?,?)");
        pre.setString(1, r.getNom_réc());
        pre.setDate(2, r.getDate_réc());
        pre.setString(3, r.getDescri_réc());
        
        pre.executeUpdate();
    }

    public boolean update(Reclamation a){
        Connection cnx =null;
        Statement st = null;
        
        
        String requette = "UPDATE reclamation SET traite='"+a.getTraite()+"' WHERE id_rec="+a.getId_réc()+"";
                     
        
        
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

    public boolean delete(Reclamation a){
        Connection cnx =null;
        Statement st = null;
        String requette = "DELETE FROM reclamation WHERE id_rec="+a.getId_réc()+"";
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

    public List<Reclamation> readAll1() throws SQLException {

        List<Reclamation> lu = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select id_rec ,nom_rec,date_rec,descri_rec,traite  from reclamation");
        while (rs.next()) {
            int id_réc = rs.getInt("id_rec");
            String nom_réc = rs.getString("nom_rec");
            Date date_réc = rs.getDate("date_rec");
            String descri_réc = rs.getString("descri_rec");
            String traite = rs.getString("traite");
            
            

            Reclamation r = new Reclamation(id_réc, nom_réc,descri_réc,date_réc,traite);
            lu.add(r);
        }
        return lu;
    }

}
