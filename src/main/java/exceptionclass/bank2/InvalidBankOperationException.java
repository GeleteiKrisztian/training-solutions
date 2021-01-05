package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidBankOperationException extends RuntimeException{

    private ErrorCode errCode;

    public InvalidBankOperationException(ErrorCode errCode) {
        this.errCode = errCode;
    }

    public ErrorCode getErrorCode() {
        return errCode;
    }

}
