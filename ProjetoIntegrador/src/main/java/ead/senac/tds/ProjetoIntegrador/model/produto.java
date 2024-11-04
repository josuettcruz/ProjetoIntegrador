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
    
    private int contains;
    
    private int id;
    private String desc;
    private marca marca;
    
    public produto(){
        
        this.contains = 0;
        
        this.id = 0;
        this.desc = "";
        this.marca = new marca();
        
    }//produto()
    
    public void Content(){
        this.contains ++;
    }
    
    public int isItem(){
        return this.contains;
    }
    
    public boolean notItens(){
        return this.contains == 0;
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
    
    public String ReturnId(){
        
        String txt = "Nº ";
        
        if(this.id < 10){
            txt += "000";
            txt += this.id;
        } else if(this.id < 100){
            txt += "00";
            txt += this.id;
        } else if(this.id < 1000){
            txt += this.id;
        } else {
            txt += "+999";
        }
        
        return txt;
        
    }//ReturnId()
    
}
