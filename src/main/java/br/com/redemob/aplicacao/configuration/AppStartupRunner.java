package br.com.redemob.aplicacao.configuration;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.redemob.dominio.modelo.Cliente;
import br.com.redemob.dominio.service.ClienteService;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger LOG =
      LoggerFactory.getLogger(AppStartupRunner.class);

    public static int counter;
    
    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Criando admin");
        
        Cliente cliente = new Cliente("99999999999", "12345678", "Administrador", "", new Date(), "", "", "", 1);
        var novoAdmin = this.clienteService.create(cliente);
        LOG.info(novoAdmin.toString());
        
        counter++;
    }
}