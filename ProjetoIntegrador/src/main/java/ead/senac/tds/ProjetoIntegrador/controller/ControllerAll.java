/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.controller;

import ead.senac.tds.ProjetoIntegrador.model.*;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author josue
 */

@Controller
public class ControllerAll {
    
    final String divtopclass = "container-fluid bg-primary-subtle pt-2 " + 
            "d-print-none";
    final String divtopstyle = "padding-top: 1vh;padding-bottom:2vh";
    final String htopclass = "text-primary-emphasis text-center";
    final String htopstyle = "font-size: 4vw";
    
    final String lbl_marca = "Detalhes:";
    String label_marca = lbl_marca;
    
    private void Page(String nome){
        
        if(!nome.equalsIgnoreCase("marca")){
            this.label_marca = lbl_marca;
        }
        
    }//Page(String nome)
    
    private void Form(String nome){
        
        System.out.println("Formulário: \"" + nome.toUpperCase() + "\"");
        
    }//Form(String nome)
    
    @GetMapping("/")
    public String Index(Model model){
        
        Page("index");
        
        Data d = new Data(Registro.Real());
        
        model.addAttribute("title", d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
        Lista lt = new Arquivo().Arq();
        
        //item
        model.addAttribute("cit", !lt.Itens().isEmpty());
        model.addAttribute("eit", lt.Itens());
        
        //produto
        model.addAttribute("cpro", !lt.Produtos().isEmpty());
        model.addAttribute("epro", lt.Produtos());
        
        //marca
        model.addAttribute("cmac", !lt.Marcas().isEmpty());
        model.addAttribute("emac", lt.Marcas());
        
        /* Bootstrap -- div -- Topo */
        model.addAttribute("divtopclass", this.divtopclass);
        model.addAttribute("divtopstyle", this.divtopstyle);
        /* divtopclass -- div top class */
        
        /* Bootstrap -- div -- h1 -- Topo */
        model.addAttribute("htopclass", this.htopclass);
        model.addAttribute("htopstyle", this.htopstyle);
        model.addAttribute("emac", lt.Marcas());
        model.addAttribute("htopclass", "text-primary-emphasis text-center");
        model.addAttribute("htopstyle", "font-size: 4vw");
        /* Bootstrap -- div -- Topo */
        
        /* Bootstrap -- div -- Link para os formulários */
        String div1class = "container-sm bg-success-subtle ";
        div1class += "border border-success my-3 p-2";
        
        if(!lt.Produtos().isEmpty()){
            div1class += " d-print-none";
        }
        
        model.addAttribute("div1class", div1class);
        model.addAttribute("div1aclass", "link-dark link-offset-1 " + 
                "link-underline link-underline-opacity-0 " + 
                "link-underline-opacity-75-hover " + 
                "text-center fs-3 fw-bold");
        /* div1 -- div 1 class */
        
        /* Bootstrap -- table -- Lista de itens */
        model.addAttribute("tclass", "table table-info " + 
                "table-striped table-hover");
        /* titemclass -- t - tabela -- class */
        
        return "index";
        
    }//Index(Model model)
    
    //novamarca - página
    @GetMapping("/marca")
    public String NovaMarca(Model model){
        
        Page("marca");
        
        Data d = new Data(Registro.Real());
        
        model.addAttribute("host", Registro.Host());
        
        model.addAttribute("title", d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
        /* Bootstrap -- div -- Topo */
        model.addAttribute("divtopclass", this.divtopclass);
        model.addAttribute("divtopstyle", this.divtopstyle);
        model.addAttribute("htopclass", this.htopclass);
        model.addAttribute("htopstyle", this.htopstyle);
        /* Bootstrap -- div -- Topo */
        
        model.addAttribute("div_form", "container-fluid mt-5 p-2 " + 
                "bg-success-subtle d-print-none");
        
        model.addAttribute("div_container", "container-fluid mt-5 p-2 " + 
                "bg-success-subtle");
        
        model.addAttribute("div_row", "row row-cols-2");
        model.addAttribute("div_col", "col-sm");
        model.addAttribute("lbl", this.label_marca);
        
        model.addAttribute("label", "form-label d-block" + 
                "text-center text-dark fs-2");
        
        model.addAttribute("input", "form-control form-control-lg d-block ");
        model.addAttribute("submit", "btn btn-outline-success btn-lg mt-2");
        model.addAttribute("reset", "btn btn-outline-danger btn-lg mt-2");
        model.addAttribute("cancel", "btn btn-outline-warning btn-lg mt-2");
        
        //Listagem de marcas
        List<marca> mac = new Arquivo().Arq().Marcas();
        model.addAttribute("com_mac", !mac.isEmpty());
        model.addAttribute("marca", mac);
        
        // Bootstrap -- tabela com a lista de marcas
        model.addAttribute("div_container", "container-fluid " + 
                "bg-success-subtle mt-5 py-5");
        
        model.addAttribute("div_title", "d-block pb-5 " + 
                "border-bottom border-5 border-success");
        
        model.addAttribute("div_row", "row row-cols-2 justify-content-between");
        
        model.addAttribute("col1", "bg-info " + 
                "pe-5 col text-center text_black fs-2 fw-bold");
        
        model.addAttribute("col2", "bg-danger " + 
                "pe-5 col text-center text_black fs-2 fw-bold");
        
        model.addAttribute("div_text", "d-block pt-5 " + 
                "border-top border-5 border-success");
        
        model.addAttribute("text", "pt-5 text-black text-start fs-3 fw-medium");
        
        return "novamarca";
        
    }//Index(Model model)
    
    //novamarca - formulário
    @GetMapping("/mac")
    public String formMarca(Model model, String txt){
        
        Form("mac");
        
        if(txt.trim().length() >= 5){
        
            new Arquivo().AddMarca(new marca(txt.trim()));
            this.label_marca = this.lbl_marca;
            return "redirect:/";
        
        } else {//if(txt.trim().length() >= 5)
            
            this.label_marca = "* " + this.lbl_marca + " (MÍNIMO 5 CARACTERES)";
            return "redirect:/marca";
            
        }//if(txt.trim().length() >= 5)
        
    }//formMarca(Model model, @ModelAttribute marca mac)
    
    //novamarca - formulário
    @GetMapping("/del_mac")
    public String delMarca(Model model, String cod){
        
        Form("del_mac");
        
        boolean value = false;
        
        Arquivo arq = new Arquivo();
        
        Numero num = new Numero(cod);
        
        if(num.Val()){
            
            value = arq.deleteMarca(num.Num());
            
        }//if(num.Val())
        
        if(value){
            
            return "redirect:/";
            
        } else {//if(value)
            
            return "redirect:/marca";
            
        }//if(value)
        
    }//formMarca(Model model, @ModelAttribute marca mac)
    
    //editmarca - página
    @GetMapping("/mac_view")
    public String editarMarca(Model model, String cod){
        
        Page("mac_view");
        
        Data d = new Data(Registro.Real());
        
        model.addAttribute("title", d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
        /* Bootstrap -- div -- Topo */
        model.addAttribute("divtopclass", this.divtopclass);
        model.addAttribute("divtopstyle", this.divtopstyle);
        model.addAttribute("htopclass", this.htopclass);
        model.addAttribute("htopstyle", this.htopstyle);
        /* Bootstrap -- div -- Topo */
        
        model.addAttribute("div_form", "container-xxl mt-5 py-2 py-xxl-5 " + 
                "bg-warning-subtle d-print-none");
        
        model.addAttribute("form_control", "form-control form-control-lg");
        model.addAttribute("button_submit", "btn btn-success btn-lg");
        model.addAttribute("button_return", "btn btn-warning btn-lg");
        model.addAttribute("button_clear", "btn btn-danger btn-lg");
        
        model.addAttribute("list_container", "container-xxl my-5 py-3 " + 
                "bg-dark-subtle");
        
        model.addAttribute("list_title", "my-2 text-center " + 
                "text-primary-emphasis fs-1 fw-bold " + 
                "d-none d-print-block");
        
        model.addAttribute("list", "my-2 my-xxl-5 ps-5 ps-xxl-2 pt-5 pt-xxl-2 " + 
                "text-body-emphasis text-break fs-3 fw-semibold");
        
        boolean acept = false;
        
        List<marca> lista = new Arquivo().Arq().Marcas();
        
        model.addAttribute("title", d.DataAbreviada(false));
        model.addAttribute("host", Registro.Host() + "marca");
        
        marca mac = new marca();
        
        Numero doc = new Numero(cod);
        
        if(doc.Val()){
            
            for(marca mc : lista){
                
                if(mc.getId() == doc.Num()){
                    
                    mac = mc;
                    acept = true;
                    break;
                    
                }//if(mc.getId() == doc.Num())
                
            }//for(marca mc : lista)
            
        }//if(doc.Val())
        
        model.addAttribute("form_type_hidden", mac.getId());
        model.addAttribute("value", mac.Read().get(mac.Read().size()-1));
        model.addAttribute("text", mac.Read());
        model.addAttribute("number", "MARCA [" + mac.ReturnId() + "]");
        
        //formClearMarca(Model model, String id)
        model.addAttribute("reset", Registro.Host() + 
                "mac_clear?id=" + 
                mac.getId());
        
        if(acept){
            return "editmarca";
        } else {
            return "redirect:/marca";
        }
        
    }//editarMarca(Model model, String cod)
    
    //editmarca - formulário
    @GetMapping("/mac_modify")
    public String formEditarMarca(Model model, String id, String txt){
        
        Form("mac_modify");
        
        boolean valid = false;
        
        List<marca> lista = new Arquivo().Arq().Marcas();
        
        Numero doc = new Numero(id);
        
        marca marca = new marca();
        
        if(doc.Val()){
            
            for(marca mac : lista){
                
                if(mac.getId() == doc.Num()){
                    
                    marca = mac;
                    valid = true;
                    break;
                    
                }//if(mac.getId() == doc.Num())
                
            }//for(marca mac : lista)
            
        }//if(doc.Val())
        
        if(valid){
            
            marca.Add(txt, true);
            new Arquivo().AlterMarca(marca, doc.Num());
            
            //return "redirect:/mac_view?cod=" + id;
            
        }
        
        return "redirect:/mac_view?cod=" + id;
        
    }//formEditarMarca(Model model, String id, String txt)
    
    //editmarca - formulário
    @GetMapping("/mac_clear")
    public String formClearMarca(Model model, String id){
        
        Form("mac_clear");
        
        boolean valid = false;
        
        List<marca> lista = new Arquivo().Arq().Marcas();
        
        Numero doc = new Numero(id);
        
        marca marca = new marca();
        
        if(doc.Val()){
            
            for(marca mac : lista){
                
                if(mac.getId() == doc.Num()){
                    
                    marca = mac;
                    valid = true;
                    break;
                    
                }//if(mac.getId() == doc.Num())
                
            }//for(marca mac : lista)
            
        }//if(doc.Val())
        
        if(valid && marca.Read().size() > 1){
            
            int end = marca.Read().size()-1;
            
            String txt = marca.Read().get(end);
            
            marca.Add(txt, false);
            new Arquivo().AlterMarca(marca, doc.Num());
            
            //return "redirect:/mac_view?cod=" + id;
            
        }
        
        return "redirect:/mac_view?cod=" + id;
        
    }//formEditarMarca(Model model, String id, String txt)
    
    //novoproduto -- página
    @GetMapping("/produtos")
    public String AddProduto(Model model){
        
        Page("index");
        
        Data d = new Data(Registro.Real());
        
        model.addAttribute("title", d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
        model.addAttribute("divtopclass", this.divtopclass);
        model.addAttribute("divtopstyle", this.divtopstyle);
        model.addAttribute("htopclass", this.htopclass);
        model.addAttribute("htopstyle", this.htopstyle);
        model.addAttribute("htopclass", "text-primary-emphasis text-center");
        model.addAttribute("htopstyle", "font-size: 4vw");
        /* Bootstrap -- div -- Topo */
        
        Lista lt = new Arquivo().Arq();
        
        //Form
        model.addAttribute("cancel", Registro.Host());
        model.addAttribute("mac", lt.Marcas());
        
        //Form -- Bootstrap
        model.addAttribute("div_form", "container-fluid my-5 my-sm-2 " + 
                "bg-success-subtle " + 
                "d-print-none");
        
        model.addAttribute("input_text", "form-control");
        model.addAttribute("input_select", "form-select d-block");
        model.addAttribute("btn_submit", "btn btn-success btn-lg d-block");
        model.addAttribute("btn_cancel", "btn btn-warning btn-lg d-block");
        
        //Lista
        model.addAttribute("listar", lt.Produtos());
        
        //Form -- Bootstrap
        model.addAttribute("div_lista", "container-fluid my-5 my-xxl-2");
        model.addAttribute("lista", "ps-5 ps-xxl-2 py-5 py-lg-2");
        model.addAttribute("lista_link", "link-secondary display-2 fw-bold " + 
                "text-center");
        
        model.addAttribute("lista_p", "text-success-emphasis fs-4 fw-medium");
        
        return "novoproduto";
        
    }//AddProduto(Model model)
    
    //novoproduto -- formulário
    @GetMapping("/add_pro")
    public String formAddProduto(Model model, String desc, String mac){
        
        Form("add_pro");
        
        Lista lt = new Arquivo().Arq();
        
        Numero num = new Numero(mac);
        
        if(num.Val()){
            
            produto pro = new produto();
            pro.setDesc(desc);
            
            for(marca mc : lt.Marcas()){
                
                if(mc.getId() == num.Num()){
                    
                    pro.setMarca(mc);
                    break;
                    
                }//if(mc.getId() == num.Num())
                
            }//for(marca mc : lt.Marcas())
            
            new Arquivo().addProduto(pro);
            
        }//if(num.Val())
        
        return "redirect:/";
        
    }//formAddProduto(Model model, String desc, String mac)
    
}