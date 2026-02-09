package com.NoletoTech.bffagendadortarefas.infrastructure.client.Config;

import com.NoletoTech.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.NoletoTech.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.NoletoTech.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.NoletoTech.bffagendadortarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {

            case 409:
                return new ConflictException("Erro atributo existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo não encontrado");

            case 401:
                return new UnauthorizedException("Erro usuário não autorizado");

            default:
                return new BusinessException("Erro de servidor");

        }
    }
}
