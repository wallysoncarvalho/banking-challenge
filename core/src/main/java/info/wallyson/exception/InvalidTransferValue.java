package info.wallyson.exception;

import info.wallyson.usecases.TransferData;

public class InvalidTransferValue extends BaseDomainException {
  public InvalidTransferValue() {
    super("Transfer values must be greater than zero or less/equal to 2000");
  }
}
