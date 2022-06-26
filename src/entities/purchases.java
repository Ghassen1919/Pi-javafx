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
public class purchases {
int id,rib;

    public purchases(int id, int rib) {
        this.id = id;
        this.rib = rib;
    }

    public purchases(int rib) {
        this.rib = rib;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRib() {
        return rib;
    }

    public void setRib(int rib) {
        this.rib = rib;
    }



    
    
    
}
