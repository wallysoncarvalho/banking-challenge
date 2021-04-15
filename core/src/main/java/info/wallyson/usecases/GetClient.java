package info.wallyson.usecases;

import info.wallyson.domain.Client;
import info.wallyson.domain.Identifier;
import info.wallyson.exception.ClientNotFoundException;
import info.wallyson.ports.ClientRepository;

public class GetClient {
  private final ClientRepository clientRepository;

  public GetClient(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public Client get(Identifier id) {

    return clientRepository
        .findById(id.getId())
        .orElseThrow(() -> new ClientNotFoundException(id.getId()));
  }
}
