/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.controller;

import ead.senac.tds.ProjetoIntegrador.model.*;
import java.time.LocalTime;
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
    
    final String divtopclass = "container-fluid bg-primary-subtle pt-xxl-2";
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
        
        Lista lt = new Arquivo().Arq();
        
        model.addAttribute("title", d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
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
        model.addAttribute("div1class", "container-sm bg-success-subtle " + 
                "border border-success my-3 p-2");
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
        
        model.addAttribute("div_container", "container-fluid mt-5 p-2 bg-success-subtle");
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
                "bg-success-subtle mt-xxl-5 py-xxl-5");
        
        model.addAttribute("div_title", "d-block pb-5 " + 
                "border-bottom border-5 border-success");
        
        model.addAttribute("div_row", "row justify-content-between");
        
        model.addAttribute("col", "pe-5 col text_black fs-2 fw-bold");
        
        model.addAttribute("div_text", "d-block pt-5 " + 
                "border-top border-5 border-success");
        
        model.addAttribute("text", "pt-5 text-black text-start fs-3 fw-medium");
        
        model.addAttribute("del_class", "btn btn-danger");
        model.addAttribute("del_style", "width: 100%;magin-bottom:15%");
        
        return "novamarca";
        
    }//Index(Model model)
    
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
    
}
