/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.controller;

import ead.senac.tds.ProjetoIntegrador.model.*;
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
    
    @GetMapping("/")
    public String Index(Model model){
        
        Data d = new Data(Registro.Real());
        
        Lista lt = new Arquivo().Arq();
        
        model.addAttribute("title", d.DataLinha(true) + " - " +
                d.DataAbreviada(false));
        
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
        /* htopclass -- h1 top class */
        
        /* Bootstrap -- div -- h1 -- Topo */
        model.addAttribute("htopclass", "text-primary-emphasis text-center");
        model.addAttribute("htopstyle", "font-size: 4vw");
        /* htopclass -- h1 top class */
        
        /* Bootstrap -- div -- Link para os formulários */
        model.addAttribute("div1class", "container-sm bg-success-subtle " + 
                "border border-success my-3 p-2 " + 
                "text-center text-black fs-3 fw-bold");
        /* div1 -- div 1 class */
        
        /* Bootstrap -- table -- Lista de itens */
        model.addAttribute("titemclass", "table table-info table-striped table-hover");
        /* titemclass -- t - tabela -- item -- class */
        
        return "index";
        
    }//Index(Model model)
    
    @GetMapping("/marca")
    public String NovaMarca(Model model){
        
        Data d = new Data(Registro.Real());
        
        model.addAttribute("title", d.DataLinha(true) + " - " +
                d.DataAbreviada(false));
        
        model.addAttribute("top", "Hoje é " + 
                new Data().DataCompleta(true) + 
                "!");
        
        /* Bootstrap -- div -- Topo */
        model.addAttribute("divtopclass", this.divtopclass);
        model.addAttribute("divtopstyle", this.divtopstyle);
        model.addAttribute("htopclass", this.htopclass);
        model.addAttribute("htopstyle", this.htopstyle);
        /* htopclass -- h1 top class */
        /* htopclass -- h1 top class */
        
        return "novamarca";
        
    }//Index(Model model)
    
    @GetMapping("/mac")
    public String formaMarca(Model model, @ModelAttribute marca mac){
        
        new Arquivo().AddMarca(mac);
        
        return "redirect:/";
        
    }
    
}
