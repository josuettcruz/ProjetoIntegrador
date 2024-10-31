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
public class Lista {
    
    private List<item> itens;
    private List<produto> produtos;
    private List<marca> marcas;
    
    public Lista(){
        
        this.itens = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.marcas = new ArrayList<>();
        
    }//Lista()
    
    public void newMarca(marca marca){
        
        marca mac = marca;
        mac.setId(this.marcas.size() + 1);
        this.marcas.add(mac);
        
    }//newMarca(marca marca)
    
    public boolean newProduto(produto produto, int cod){
        
        boolean valid = false;
        
        produto pro = produto;
        pro.setId(this.produtos.size() + 1);
        
        for(marca m : marcas){
            
            if(m.getId() == cod){
                
                pro.setMarca(m);
                valid = true;
                break;
                
            }
            
        }//for(marca m : marcas)
        
        if(valid){
            this.produtos.add(pro);
        }
        
        return valid;
        
    }//newProduto(produto produto, int cod)
    
    public boolean newItem(item item, int cod){
        
        boolean valid = false;
        
        item it = item;
        it.setId(this.itens.size() + 1);
        
        for(produto p : produtos){
            
            if(p.getId() == cod){
                
                it.setProduto(p);
                valid = true;
                break;
                
            }
            
        }//for(produto p : produtos)
        
        if(valid){
            this.itens.add(it);
        }
        
        return valid;
        
    }//public boolean newItem(item item, int cod)
    
    public List<marca> Marcas(){
        return this.marcas;
    }
    
    public List<produto> Produtos(){
        return this.produtos;
    }
    
    public List<item> Itens(){
        return this.itens;
    }
    
    public marca Marca(int cod){
        
        marca exe = new marca();
        
        for(marca m : this.marcas){
            
            if(m.getId() == cod){
                
                exe = m;
                break;
                
            }
            
        }
        
        return exe;
        
    }//Marcas(int num)
    
    public produto Produto(int cod){
        
        produto exe = new produto();
        
        for(produto p : this.produtos){
            
            if(p.getId() == cod){
                exe = p;
            }
            
        }
        
        return exe;
        
    }//Produto(int cod)
    
    public item Item(int cod){
        
        item exe = new item();
        
        for(item i : this.itens){
            
            if(i.getId() == cod){
                
                exe = i;
                break;
                
            }
            
        }
        
        return exe;
        
    }//Item(int cod)
    
}