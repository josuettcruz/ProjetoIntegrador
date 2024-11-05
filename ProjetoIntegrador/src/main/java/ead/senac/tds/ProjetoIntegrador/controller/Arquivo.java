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
                    
                    mc.Add(arq_marca.Read(i, j), true);
                    
                }//for(int j = 0; j < arq_marca.Tot(i); j++)
                
                list.newMarca(mc);
                
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
    
    public boolean AlterMarca(marca mac, int cod){
        
        boolean valid = true;
        
        int num = -1;
        
        Lista document = this.Arq();
        
        int i = 0;
        
        do{
            
            if(document.Marcas().get(i).getId() == cod){
                
                num = i;
                
            }
            
            i++;
            
        }while(num <= 0 && i < document.Marcas().size());
        
        if(num >= 0 && mac.Max() > 0){
            
            csv doc = new csv(files_marca);

            doc.Reply(num, mac.Read());
            
        } else {
            
            valid = false;
            
        }
        
        
        return valid;
        
    }//AlterMarca(marca mac, int cod)
    
    public boolean AlterProduto(produto pro, int cod){
        
        boolean valid = true;
        
        int num = -1;
        
        Lista document = this.Arq();
        
        int i = 0;
        
        do{
            
            if(document.Produtos().get(i).getId() == cod){
                
                num = i;
                
            }
            
            i++;
            
        }while(num <= 0 && i < document.Produtos().size());
        
        if(num >= 0){
            
            csv doc = new csv(files_produto);

            String[] dados = new String[2];

            dados[0] = "";
            dados[0] += pro.getMarca().getId();

            dados[1] = pro.gedDesc();

            doc.Reply(num, dados);
            
        } else {
            
            valid = false;
            
        }
        
        return valid;
        
    }//AlterProduto(produto pro, int cod)
    
    public boolean AlterItem(item it, int cod){
        
        boolean valid = true;
        
        int num = -1;
        
        Lista document = this.Arq();
        
        int i = 0;
        
        do{
            
            if(document.Itens().get(i).getId() == cod){
                
                num = i;
                
            }
            
            i++;
            
        }while(num <= 0 && i < document.Itens().size());
        
        if(num >= 0){
            
            csv doc = new csv(files_item);

            String[] dados = new String[5];

            dados[0] = "";
            dados[0] += it.getProduto().getId();

            dados[1] = it.getNome();

            dados[2] = "";
            dados[2] += it.getDesc().getStatus();

            dados[3] = it.getDesc().getData().Load();

            dados[4] = it.getDesc().getHora().Load();
            
            doc.Reply(num, dados);
        
        } else {
            valid = false;
        }
        
        return valid;
        
    }//AlterItem(item it, int cod)
    
    public boolean deleteMarca(int cod){
        
        boolean valid = true;
        
        Lista l = this.Arq();
        
        int num = -1;
        
        for(marca m : l.Marcas()){
            
            if(m.getId() == cod){
                num = m.getId();
                break;
            }
            
        }
            
        for(produto p : l.Produtos()){

            if(p.getMarca().getId() == num){

                valid = false;
                break;

            }

        }
        
        if(valid && num > 0){
            
            csv del = new csv(files_marca);
            
            valid = false;
            
            for(int x = 0; x < l.Marcas().size(); x++){
                
                if(l.Marcas().get(x).getId() == cod){
                    
                    del.Remove(x);
                    valid = true;
                    
                }
                
            }
            
        }
        
        return valid;
        
    }//deleteMarca(int cod)
    
    public boolean deleteProduto(int cod){
        
        boolean valid = true;
        
        Lista l = this.Arq();
        
        int num = -1;
        
        for(produto p : l.Produtos()){
            
            if(p.getId() == cod){
                num = p.getId();
                break;
            }
            
        }
            
        for(item i : l.Itens()){

            if(i.getProduto().getId() == num){

                valid = false;
                break;

            }

        }
        
        if(valid && num >= 0){
            
            csv del = new csv(files_produto);
            
            valid = false;
            
            for(int x = 0; x < l.Produtos().size(); x++){
                
                if(l.Produtos().get(x).getId() == cod){
                    
                    del.Remove(x);
                    valid = true;
                    
                }
                
            }
            
        }
        
        return valid;
        
    }//deleteProduto(int cod)
    
    public boolean deleteItem(int cod){
        
        boolean valid = false;
        
        Lista l = this.Arq();
        
        csv del = new csv(files_item);
        
        for(int x = 0; x < l.Itens().size(); x++){
            
            if(l.Itens().get(x).getId() == cod){
                
                del.Remove(x);
                valid = true;
                break;
                
            }
            
        }
        
        return valid;
        
    }//deleteItem(int cod)
    
}