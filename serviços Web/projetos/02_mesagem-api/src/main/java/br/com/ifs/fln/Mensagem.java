package br.com.ifs.fln;

import jdk.jfr.DataAmount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


public class Mensagem {

	private final long id;
	private final String conteudo;

    public Mensagem(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

	public long getId() {return id;	}
	public String getConteudo() {return conteudo;	}

}
