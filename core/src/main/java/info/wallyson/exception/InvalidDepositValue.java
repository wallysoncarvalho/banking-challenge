package info.wallyson.exception;

public class InvalidDepositValue extends BaseDomainException{
    public InvalidDepositValue() {
        super("Deposit values must be equal or greater than 1.");
    }
}
