package ead.senac.tds.ProjetoIntegrador;

import ead.senac.tds.ProjetoIntegrador.model.Data;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoIntegradorApplication {

	public static void main(String[] args) {
            
		//SpringApplication.run(ProjetoIntegradorApplication.class, args);
                
                LocalDate envio = LocalDate.of(2024, 10, 29);
                
                System.out.println("Hoje é " + new Data().DataCompleta() + "!");
                System.out.println("RS-20241-TDS-M3-UC15-660011453E TDS");
                System.out.println();
                System.out.println("Mód III\t\tProjeto Integrador Assistente de desenvolvimento de sistemas");
                System.out.println("ALUNO\t\tJosué Trindade Torres Cruz");
                System.out.println("REALIZAÇÃO\t" + new Data(envio).DataAbreviada() + " - " + new Data(envio).DataLinha() + "");
                System.out.println();
                System.out.println("Atividade 2 do Projeto Integrador");
                System.out.println("Acesso ao conteúdo pelo link abaixo:");
                System.out.println("http://localhost:8080/page");
                
	}

}
