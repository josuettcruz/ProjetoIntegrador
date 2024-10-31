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
        
        model.addAttribute("citen", !lt.Itens().isEmpty());
        model.addAttribute("eiten", model);
        
        model.addAttribute("localhost", Registro.Host());
        
        return "index";
        
    }
    
}
