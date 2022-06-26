/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author MSI GL-65
 */
public class games {
 
    int id,stock;
    String name,category,release_year,description,img;
    double price;
    

    public games(String name, String category, String release_year, double price, String description, String img , int stock) {
        this.name = name;
        this.category = category;
        this.release_year = release_year;
        this.price = price;
        this.description = description;
        this.img = img;
        this.stock = stock;
    }

        public games(int id,String name, String category, String release_year, double price, String description, String img , int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.release_year = release_year;
        this.price = price;
        this.description = description;
        this.img = img;
        this.stock = stock;
    }
//CONST WITH BYTE

        public games(){
            
        }


 
        
    
    

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
    
}
