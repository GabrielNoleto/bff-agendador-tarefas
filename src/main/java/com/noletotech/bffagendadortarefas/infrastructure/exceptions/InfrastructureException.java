package com.noletotech.bffagendadortarefas.infrastructure.exceptions;

public class InfrastructureException extends RuntimeException {
    public InfrastructureException(String mensagem) {
        super(mensagem);
    }
    public InfrastructureException (String mensagem, Throwable throwable){
        super(mensagem,throwable);
    }
}
