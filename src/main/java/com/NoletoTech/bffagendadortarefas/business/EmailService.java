package com.NoletoTech.bffagendadortarefas.business;

import com.NoletoTech.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.NoletoTech.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto){
        emailClient.enviarEmail(dto);
    }

}