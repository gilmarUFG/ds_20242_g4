package com.registro.vacina.RegistroVacina.services.envioNotificacao;

import org.springframework.stereotype.Service;

@Service
public class SMSNotificationSender {
    public void send(String numTelefone, String message) {
        // Simulação de envio de SMS
        System.out.println("Enviando SMS para " + numTelefone + ": " + message);
    }
}