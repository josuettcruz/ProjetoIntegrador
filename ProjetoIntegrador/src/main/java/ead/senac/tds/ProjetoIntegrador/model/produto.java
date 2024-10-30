/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

/**
 *
 * @author josue
 */
public class produto {
    
    private int id;
    private String desc;
    private marca marca;
    
    public produto(){
        this.id = 0;
        this.desc = "";
        this.marca = new marca();
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public void setMarca(marca marca){
        this.marca = marca;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String gedDesc(){
        return this.desc;
    }
    
    public marca getMarca(){
        return this.marca;
    }
    
}
