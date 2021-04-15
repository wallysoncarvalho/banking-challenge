package info.wallyson.usecases;

import info.wallyson.exception.ClientNotFoundException;
import info.wallyson.util.ClientCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GetClientTests extends TestBaseClass {
  private GetClient getClient;

  @BeforeEach
  void setUp() {
    getClient = new GetClient(clientRepository);
  }

  @Test
  @DisplayName("Should throw exception if client is not found")
  void shouldThrowExceptionIfClientNotFound() {
    var client = ClientCreator.single();

    when(clientRepository.findById(client.getIdentifier().getId())).thenReturn(Optional.empty());

    assertThrows(ClientNotFoundException.class, () -> getClient.get(client.getIdentifier()));

    verify(clientRepository, times(1)).findById(client.getIdentifier().getId());
  }

  @Test
  @DisplayName("Should get information of existing client")
  void shouldGetInformationOfClient() {
    var client = ClientCreator.single();

    when(clientRepository.findById(client.getIdentifier().getId())).thenReturn(Optional.of(client));

    var returnedClient = getClient.get(client.getIdentifier());

    assertNotNull(returnedClient);
    assertEquals(client.getIdentifier(), returnedClient.getIdentifier());

    verify(clientRepository, times(1)).findById(client.getIdentifier().getId());
  }
}
