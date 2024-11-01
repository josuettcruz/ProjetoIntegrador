/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class marca {
    
    private int id;
    private List<String> detals;
    
    public marca(){
        this.id = 0;
        this.detals = new ArrayList<>();
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void Add(String txt){
        this.detals.add(txt);
    }
    
    public List<String> Read(){
        
        return this.detals;
        
    }
    
    public int Max(){
        return this.detals.size();
    }
    
    public String Read(int num){
        
        String txt = "";
        
        if(num >= 0 && num < this.detals.size() && !this.detals.isEmpty()){
            
            txt = this.detals.get(num);
            
        }
        
        return txt;
        
    }
    
    public boolean Clear(){
        
        boolean valid = true;
        
        if(this.detals.isEmpty()){
            valid = false;
        } else {
            this.detals.clear();
        }
        
        return valid;
        
    }//Clear()
    
    public boolean Remove(int num){
        
        boolean valid = true;
        
        if(num >= 0 && num < this.detals.size() && !this.detals.isEmpty()){
            
            this.detals.remove(num);
            
        } else {
            
            valid = false;
            
        }
        
        return valid;
        
    }//Remove(int num)
    
    private boolean AddAll(String txt, String sep){
        
        boolean valid = true;
        
        if(txt.contains(sep)){
            
            String[] doc = txt.split(sep);
            
            //https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
            this.detals.addAll(Arrays.asList(doc));
            
        } else {
            
            valid = false;
            
        }
        
        return valid;
        
    }//AddAll(String txt, String sep)
    
    public boolean AddAll(String txt){
        
        boolean event = AddAll(txt,"\n");
        
        return event;
        
    }//AddAll(String txt)
    
    public boolean AddAll(String txt, char sep){
        
        String separator = "";
        separator += sep;
        
        boolean event = AddAll(txt,separator);
        
        return event;
        
    }//AddAll(String txt, char sep)
    
}