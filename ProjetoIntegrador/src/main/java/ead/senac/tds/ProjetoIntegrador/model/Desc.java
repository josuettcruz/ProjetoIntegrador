/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

/**
 *
 * @author josue
 */
public class Desc {
    
    private Data data;
    private Hora hora;
    private int status;
    
    public Desc(){
        this.data = new Data();
        this.hora = new Hora();
        this.status = 1;
    }
    
    public void setDataTime(Data data, Hora hora){
        this.data = data;
        this.hora = hora;
    }
    
    public void setData(Data data){
        this.data = data;
    }
    
    public void setHora(Hora hora){
        this.hora = hora;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public Data getData(){
        return this.data;
    }
    
    public Hora getHora(){
        return this.hora;
    }
    
    public int getStatus(){
        return this.status;
    }
    
}