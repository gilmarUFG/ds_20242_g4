package com.registro.vacina.RegistroVacina.services;

import com.registro.vacina.RegistroVacina.dto.LoginDTO;
import com.registro.vacina.RegistroVacina.entities.Paciente;
import com.registro.vacina.RegistroVacina.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public LoginDTO validarLogin(String cpf) {
        Paciente retorno = loginRepository.findByCpf(cpf);

        if (retorno == null) {
            return null;
        }

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setNome(retorno.getNome());
        loginDTO.setCartaoSUS(retorno.getCartaoSUS());
        loginDTO.setPacienteId(retorno.getId());


        return loginDTO;
    }

}
