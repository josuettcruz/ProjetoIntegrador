/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class History {
    
    private List<Desc> list;
    private Desc atual;
    
    public History(){
        this.list = new ArrayList<>();
        this.atual = new Desc();
    }
    
    public void Add(Desc doc){
        this.list.add(doc);
        this.atual = doc;
    }
    
    public Desc Atual(){
        return this.atual;
    }
    
    public List<Desc> View(){
        return this.list;
    }
    
    public Desc View(int num){
        
        Desc d = new Desc();
        
        if(num >= 0 && num < this.list.size() && !this.list.isEmpty()){
            d = this.list.get(num);
        }
        
        return d;
        
    }//View(int num)
    
    public boolean Clear(){
        
        boolean val = true;
        
        if(this.list.isEmpty()){
            val = false;
        } else {
            this.list.clear();
        }
        
        return val;
        
    }//Clear()
    
    public boolean Remove(int num){
        
        boolean remove = true;
        
        if(num >= 0 && num < this.list.size() && !this.list.isEmpty()){
            
            this.list.remove(num);
            
        } else {
            
            remove = false;
            
        }
        
        return remove;
        
    }//Remove(int num)
    
}