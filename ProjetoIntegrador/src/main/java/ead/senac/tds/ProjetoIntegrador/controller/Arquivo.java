/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.controller;

import ead.senac.tds.ProjetoIntegrador.file.csv;
import ead.senac.tds.ProjetoIntegrador.model.*;

/**
 *
 * @author josue
 */
public class Arquivo{
    
    final String files_marca = "src\\marca";
    final String files_produto = "src\\produto";
    final String files_item = "src\\item";
    
    final String[] doc_produto = {"0","Descrição"};
    
    public Arquivo(){};
    
    public Lista Arq(){
        
        Lista list = new Lista();
        
        csv arq_marca = new csv(files_marca);
        csv arq_produto = new csv(files_produto);
        csv arq_item = new csv(files_item);
        
        if(arq_marca.Tot() > 0){
            
            for(int i = 0; i < arq_marca.Tot(); i++){
                
                //String[] dados = new String[arq_marca.Tot(i)];
                
                marca mc = new marca();
                
                for(int j = 0; j < arq_marca.Tot(i); j++){
                    
                    mc.Add(arq_marca.Read(i, j));
                    
                }//for(int j = 0; j < arq_marca.Tot(i); j++)
                
            }//for(int i = 0; i < arq_marca.Tot(); i++)
            
        }//if(marca)
        
        if(arq_produto.Tot() > 0){
            
            arq_produto.Reply(0, doc_produto);
            
            for(int i = 0; i < arq_produto.Tot(); i++){
                
                if(i > 0){
                
                    produto pro = new produto();
                    
                    Numero num = new Numero(arq_produto.Read(i, 0));
                    
                    if(num.Val()){
                        
                        pro.setDesc(arq_produto.Read(i, 1));
                        
                        list.newProduto(pro, num.Num());
                    
                    }//if(num.Val())
                
                }//if(i > 0)
                
            }//for(int i = 0; i < arq_produto.Tot(); i++)
            
        } else {//if(arq_produto.Tot() > 0)
            
            arq_produto.Insert(doc_produto);
            
        }//if(arq_produto.Tot() > 0)
        
        if(arq_item.Tot() > 0){
            
            for(int i = 0; i < arq_item.Tot(); i++){
                
                Numero num = new Numero(arq_item.Read(i, 0));
                
                if(num.Val()){
                    
                    item it = new item();
                    Desc d = new Desc();
                    
                    it.setNome(arq_item.Read(i, 1));
                    
                    Numero st = new Numero(arq_item.Read(i, 2));
                    
                    Data data = new Data(arq_item.Read(i, 3));
                    Hora hora = new Hora(arq_item.Read(i, 4));
                    
                    if(data.Val()){
                        d.setData(data);
                    }
                    
                    if(hora.Val()){
                        d.setHora(hora);
                    }
                    
                    if(st.Val() && it.cod(st.Num())){
                        
                        d.setStatus(st.Num());
                        
                    } else {
                        
                        d.setStatus(0);
                        
                    }
                    
                    list.newItem(it, num.Num());
                    
                }//if(num.Val())
                
            }//for(int i = 0; i < arq_item.Tot(); i++)
            
        }//if(arq_item.Tot() > 0)
        
        return list;
        
    }//Arquivo()
    
    public boolean AddMarca(marca marca){
        
        boolean valid = true;
        
        csv doc = new csv(files_marca);
        
        if(marca.Max() > 0){
            
            doc.Insert(marca.Read());
            
        } else {
            valid = false;
        }
        
        return valid;
        
    }//AddMarca(marca marca)
    
    public void addProduto(produto produto){
        
        csv doc = new csv(files_produto);
        
        String[] dados = new String[2];
        
        dados[0] = "";
        dados[0] += produto.getMarca().getId();
        
        dados[1] = produto.gedDesc();
        
        doc.Insert(dados);
        
    }//addProduto(produto produto)
    
    public void addItem(item item){
        
        csv doc = new csv(files_item);
        
        String[] dados = new String[5];
        
        dados[0] = "";
        dados[0] += item.getProduto().getId();
        
        dados[1] = item.getNome();
        
        dados[2] = "";
        dados[2] += item.getDesc().getStatus();
        
        dados[3] = item.getDesc().getData().Load();
        
        dados[4] = item.getDesc().getHora().Load();
        
        doc.Insert(dados);
        
    }//addItem(item item)
    
}