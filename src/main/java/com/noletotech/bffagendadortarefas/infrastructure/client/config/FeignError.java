package com.noletotech.bffagendadortarefas.infrastructure.client.config;

import com.noletotech.bffagendadortarefas.infrastructure.exceptions.*;
import com.noletotech.bffagendadortarefas.infrastructure.exceptions.IllegalArgumentException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        String mensagemErro = mensagemErro(response);
        String erro = "Erro: ";

        switch (response.status()) {

            case 409:
                return new ConflictException(erro + mensagemErro);
            case 403:
                return new ResourceNotFoundException(erro + mensagemErro);

            case 401:
                return new UnauthorizedException(erro + mensagemErro);

            case 400:
                return new IllegalArgumentException(erro + mensagemErro);

            default:
                return new BusinessException(erro + mensagemErro);

        }


    }
    private String mensagemErro(Response response) {
        try{
            if(Objects.isNull(response.body())) {
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        }catch (IOException e){
            throw new InfrastructureException("Erro ao decodificar o corpo da resposta da API externa.", e);

        }
    }
}
