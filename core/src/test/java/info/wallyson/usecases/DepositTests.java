package info.wallyson.usecases;

import info.wallyson.exception.ClientNotFoundException;
import info.wallyson.exception.InvalidDepositValue;
import info.wallyson.ports.ClientRepository;
import info.wallyson.util.ClientCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

final class DepositTests extends TestBaseClass {
  private Deposit deposit;

  @BeforeEach
  void setUp() {
    deposit = new Deposit(clientRepository);
  }

  @Test
  @DisplayName("Should throw exception to deposit zero or less")
  void shouldTrowExceptionToDepositZeroOrLess() {
    var client = ClientCreator.single();
    var clientId = client.getIdentifier().getId();

    assertThrows(InvalidDepositValue.class, () -> deposit.deposit(clientId, BigDecimal.ZERO));
    assertThrows(InvalidDepositValue.class, () -> deposit.deposit(clientId, new BigDecimal("-5")));
  }

  @Test
  @DisplayName("Should throw exception to deposit more than R$2.000,00")
  void shouldTrowExceptionToDepositMoreThanTwoThousand() {
    var client = ClientCreator.single();
    var clientId = client.getIdentifier().getId();

    assertThrows(InvalidDepositValue.class, () -> deposit.deposit(clientId, new BigDecimal("2001")));
  }

  @Test
  @DisplayName("Should throw exception when client do not exists")
  void shouldFailToDepositWhenClientDontExists() {
    var depositValue = BigDecimal.TEN;
    var client = ClientCreator.single();
    var clientId = client.getIdentifier().getId();

    when(clientRepository.findById(clientId)).thenReturn(Optional.empty());

    assertThrows(ClientNotFoundException.class, () -> deposit.deposit(clientId, depositValue));
  }

  @Test
  @DisplayName("Should successfully deposit")
  void shouldSuccessfullyDeposit() {
    var depositValue = BigDecimal.TEN;
    var client = ClientCreator.single();
    var clientId = client.getIdentifier().getId();

    when(clientRepository.findById(clientId)).thenReturn(Optional.of(client));
    deposit.deposit(clientId, depositValue);

    verify(clientRepository, times(1))
        .updateBalance(clientId, depositValue.add(client.getBalance()));
  }
}
