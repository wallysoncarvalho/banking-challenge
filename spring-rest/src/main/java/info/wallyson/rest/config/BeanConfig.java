package info.wallyson.rest.config;

import info.wallyson.ports.ClientRepository;
import info.wallyson.usecases.Deposit;
import info.wallyson.usecases.GetClient;
import info.wallyson.usecases.RegisterClient;
import info.wallyson.usecases.Transfer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
  private final ClientRepository clientRepository;

  public BeanConfig(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Bean
  public RegisterClient registerClientBean() {
    return new RegisterClient(clientRepository);
  }

  @Bean
  public Transfer transferBean() {
    return new Transfer(clientRepository);
  }

  @Bean
  public Deposit depositBean() {
    return new Deposit(clientRepository);
  }

  @Bean
  public GetClient getClientBean() {
    return new GetClient(clientRepository);
  }
}
