package exceptionclass.bank2;

import exceptionclass.bank.ErrorCode;

public class InvalidAmountBankOperationException extends InvalidBankOperationException {

    public InvalidAmountBankOperationException(ErrorCode errCode) {
        super(errCode);
    }

}
