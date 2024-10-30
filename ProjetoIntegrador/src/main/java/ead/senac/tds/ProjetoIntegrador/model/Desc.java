/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author josue
 */
public class Desc {
    
    private Data data;
    private Hora hora;
    private String desc;
    
    public Desc(){
        this.data = new Data();
        this.hora = new Hora();
        this.desc = "";
    }
    
    public Desc(String desc){
        this.data = new Data();
        this.hora = new Hora();
        this.desc = desc;
    }
    
    public Desc(Data data){
        this.data = data;
        this.hora = new Hora();
        this.desc = "";
    }
    
    public Desc(Data data, String desc){
        this.data = data;
        this.hora = new Hora();
        this.desc = desc;
    }
    
    public Desc(Data data, Hora hora){
        this.data = data;
        this.hora = hora;
        this.desc = "";
    }
    
    public Desc(Data data, Hora hora, String desc){
        this.data = data;
        this.hora = hora;
        this.desc = desc;
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
    
    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public Data getData(){
        return this.data;
    }
    
    public Hora getHora(){
        return this.hora;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
}