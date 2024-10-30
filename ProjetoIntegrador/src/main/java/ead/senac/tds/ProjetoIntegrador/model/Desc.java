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
    
    private LocalDate dia;
    private LocalTime hora;
    private String desc;
    
    public Desc(){
        this.dia = LocalDate.now();
        this.hora = LocalTime.of(0, 0, 0);
        this.desc = "";
    }
    
    public Desc(LocalDate dia){
        this.dia = dia;
        this.hora = LocalTime.of(0, 0, 0);
        this.desc = "";
    }
    
    public Desc(LocalDate dia, String desc){
        this.dia = dia;
        this.hora = LocalTime.of(0, 0, 0);
        this.desc = desc;
    }
    
    public Desc(LocalDate dia, LocalTime hora){
        this.dia = dia;
        this.hora = hora;
        this.desc = "";
    }
    
    public Desc(LocalDate dia, LocalTime hora, String desc){
        this.dia = dia;
        this.hora = hora;
        this.desc = desc;
    }
    
    public Data getData(){
        Data d = new Data(this.dia);
        return d;
    }
    
    public Hora getHora(){
        Hora h = new Hora(this.hora);
        return h;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public void setDesc(String desc){
        this.desc = desc;
    }
    
}