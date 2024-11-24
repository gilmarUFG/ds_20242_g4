package com.registro.vacina.RegistroVacina.components;

import com.registro.vacina.RegistroVacina.services.LembreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LembreteVacinaScheduler {

    @Autowired
    private LembreteService lembreteVacinaService;

    @Scheduled(cron = "0 0 8 * * *") // Envia todos os dias às 8h
    public void agendarEnvioLembretes() {
        try {
            lembreteVacinaService.enviarLembretes();
        } catch(Exception e) {
            // Tratar exceções de envio, caso necessário
            System.err.println("Erro ao enviar lembretes: " + e.getMessage());
        }
    }
}
