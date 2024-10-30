/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class item {
    
    final String[] status = {"disponível","vendido","perdido","extornado"};
    
    protected int id;
    protected String nome;
    protected Desc desc;
    protected produto produto;
    protected History history;
    
    public item(){
        this.id = 0;
        this.nome = "";
        this.desc = new Desc();
        this.produto = new produto();
        this.history = new History();
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setDesc(Desc desc){
        this.desc = desc;
        this.history.Add(desc);
    }
    
    public void setProduto(produto produto){
        this.produto = produto;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Desc getDesc(){
        return this.desc;
        
    }
    
    public produto getProduto(){
        return this.produto;
    }
    
    public History History(){
        return this.history;
    }
    
    public boolean Data(String data){
        
        boolean valid = true;
        
        Data d = new Data(data);
        
        if(d.Val()){
            
            this.desc.setData(d);
            
        } else {
            
            valid = false;
            
        }
        
        return valid;
        
    }//Data(String data)
    
    public boolean Hora(String hora){
        
        boolean valid = true;
        
        Hora h = new Hora(hora);
        
        if(h.Val()){
            
            this.desc.setHora(h);
            
        } else {
            
            valid = false;
            
        }
        
        return valid;
        
    }//Hora(String hora)
    
    public List<String> Status(){
        
        //https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
        
        return Arrays.asList(this.status);
        
    }//Status()
    
    public String Status(int numb){
        
        int num = numb - 1;
        
        if(num >= 0 && num < this.status.length){
            
            return status[num];
            
        } else {
            
            return "Valor Inválido!";
            
        }
        
    }//Status(int numb)
    
    public int cod(){
        
        int num = 0;
        
        for(int n = 0; n < status.length; n++){
            
            String text = this.desc.getDesc();
            
            if(status[n].equalsIgnoreCase(text)){
                
                num = n+1;
                break;
                
            }
            
        }//for(int n = 0; n < status.length; n++)
        
        return num;
        
    }//cod()
    
    public int cod(int num){
        
        int number = 0;
        
        if(this.history.Val(num)){
        
            for(int n = 0; n < status.length; n++){

                String text = this.history.View(num).getDesc();

                if(status[n].equalsIgnoreCase(text)){

                    num = n+1;
                    break;

                }

            }//for(int n = 0; n < status.length; n++)
        
        } else {//if(this.history.Val(num))
            
            number = -1;
            
        }//if(this.history.Val(num))
        
        return number;
        
    }//cod()
    
    public boolean newStatus(int cod){
        
        int num = cod-1;
        
        if(num >= 0 && num < this.status.length){
            
            Data date = new Data();
            Hora hour = new Hora();
            
            this.desc.setDataTime(date, hour);
            this.history.Add(this.desc);
            
            return true;
            
        } else {
            return false;
        }
        
    }//newStatus(int cod)
    
    public boolean newStatus(int cod, String date){
        
        int num = cod-1;
        
        if(num >= 0 && num < this.status.length){
            
            boolean valid = true;
            
            Data d = new Data(date);
            Hora hour = new Hora();
            
            if(d.Val()){
            
                this.desc.setDataTime(d, hour);
                this.history.Add(this.desc);
            
            } else {
                valid = false;
            }
            
            return valid;
            
        } else {
            return false;
        }
        
    }//newStatus(int cod, String date)
    
    public boolean newStatus(int cod, String date, String hora){
        
        int num = cod-1;
        
        if(num >= 0 && num < this.status.length){
            
            boolean valid = true;
            
            Data d = new Data(date);
            Hora hour = new Hora(hora);
            
            if(d.Val() && hour.Val()){
            
                this.desc.setDataTime(d, hour);
                this.history.Add(this.desc);
            
            } else {
                valid = false;
            }
            
            return valid;
            
        } else {
            return false;
        }
        
    }//newStatus(int cod, String date, String hora)
    
}