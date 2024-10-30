package ead.senac.tds.ProjetoIntegrador;

import ead.senac.tds.ProjetoIntegrador.model.Data;
import ead.senac.tds.ProjetoIntegrador.model.Registro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoIntegradorApplication {

	public static void main(String[] args) {
            
            //SpringApplication.run(ProjetoIntegradorApplication.class, args);

            Data d = new Data(Registro.Real());

            System.out.println("Hoje é " + 
                    new Data().DataCompleta(true) + 
                    "!");

            System.out.println("RS-20241-TDS-M3-UC15-660011453E TDS");

            System.out.println();

            System.out.println("Mód III\t\tProjeto Integrador Assistente de desenvolvimento de sistemas");

            System.out.println("ALUNO\t\tJosué Trindade Torres Cruz");

            System.out.println("REALIZAÇÃO\t" + 
                    d.DataAbreviada(false) + 
                    " --> " + 
                    d.DataLinha(true));

            System.out.println();

            System.out.println("Atividade 2 do Projeto Integrador");

            System.out.println("Acesso ao conteúdo pelo link abaixo:");

            System.out.println(Registro.Host());
                
	}

}
