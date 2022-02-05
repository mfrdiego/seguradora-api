package com.diego.seguradoraapi.domain.exception;


public class EntidadeNaoEncontradaException extends TratamentoException{
    private static final long serialVersionUID = 431281234321071893L;
    public EntidadeNaoEncontradaException(String message){
        super(message);
    }
}
