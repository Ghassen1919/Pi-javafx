/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;



import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.sql.*;

public class CreatePDF{
    public static void main(String arg[])throws Exception{
       Document document=new Document();
       PdfWriter.getInstance(document,new FileOutputStream("data.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(4);
        table.addCell("grpname");
       table.addCell("fullname");
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pssss", "root", "");
       Statement st=con.createStatement();
       ResultSet rs=st.executeQuery("Select * from dev");
       while(rs.next()){
         
       table.addCell(rs.getString("grpname"));
       table.addCell(rs.getString("fullname"));
       table.addCell(rs.getString("mail"));
       table.addCell(rs.getString("gender"));
       
       }
       document.add(table);
       document.close();
   }
}