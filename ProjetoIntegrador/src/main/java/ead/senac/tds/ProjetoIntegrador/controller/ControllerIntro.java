/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ead.senac.tds.ProjetoIntegrador.controller;

import ead.senac.tds.ProjetoIntegrador.model.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author josue
 */

@Controller
public class ControllerIntro {
    
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
        model.addAttribute("divtopclass", "container-fluid bg-primary-subtle pt-xxl-2");
        model.addAttribute("divtopstyle", "padding-top: 1vh;padding-bottom:2vh");
        model.addAttribute("emac", lt.Marcas());
        /* divtopclass -- div top class */
        
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
    
}
