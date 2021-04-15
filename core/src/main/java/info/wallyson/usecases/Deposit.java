package info.wallyson.usecases;

import info.wallyson.exception.ClientNotFoundException;
import info.wallyson.exception.InvalidDepositValue;
import info.wallyson.ports.ClientRepository;

import java.math.BigDecimal;

public class Deposit {
  private final ClientRepository clientRepository;

  public Deposit(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public void deposit(String clientId, BigDecimal value) {
    if (value.compareTo(new BigDecimal("0")) <= 0) throw new InvalidDepositValue();

    var client =
        clientRepository
            .findById(clientId)
            .orElseThrow(() -> new ClientNotFoundException(clientId));

    var newBalance = client.getBalance().add(value);

    clientRepository.updateBalance(client.getIdentifier().getId(), newBalance);
  }
}
