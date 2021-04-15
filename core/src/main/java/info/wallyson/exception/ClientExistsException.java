package info.wallyson.exception;

public class ClientExistsException extends BaseDomainException {
  public ClientExistsException(String id) {
    super(String.format("Client with identified '%s' already exists.", id));
  }
}
