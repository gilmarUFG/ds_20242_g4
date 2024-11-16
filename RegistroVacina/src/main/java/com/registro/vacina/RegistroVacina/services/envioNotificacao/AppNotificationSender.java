package com.registro.vacina.RegistroVacina.services.envioNotificacao;

import org.springframework.stereotype.Service;

@Service
public class AppNotificationSender {
    public void send(String cartaoSUS, String message) {
        // Simulação de envio de notificação no app
        System.out.println("Enviando notificação para o app do cartão SUS " + cartaoSUS + ": " + message);
    }
}