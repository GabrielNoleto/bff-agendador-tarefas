package com.noletotech.bffagendadortarefas.business;

import com.noletotech.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.noletotech.bffagendadortarefas.infrastructure.client.EmailClient;
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