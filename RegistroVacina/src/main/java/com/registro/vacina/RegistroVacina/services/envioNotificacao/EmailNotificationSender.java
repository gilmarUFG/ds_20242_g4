package com.registro.vacina.RegistroVacina.services.envioNotificacao;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSender {
    public void send(String email, String message) {
        // Simulação de envio de e-mail
        System.out.println("Enviando e-mail para " + email + ": " + message);
    }
}

