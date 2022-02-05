package com.diego.seguradoraapi.domain.exception;

public class TratamentoException extends RuntimeException{
    private static final long serialVersionUID = 123481234838071893L;
    public TratamentoException(String message){
        super(message);
    }
}
