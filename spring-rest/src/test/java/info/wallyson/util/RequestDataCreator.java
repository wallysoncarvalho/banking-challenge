package info.wallyson.util;

import info.wallyson.domain.CPF;
import info.wallyson.domain.Client;
import info.wallyson.rest.dto.ClientRequest;
import info.wallyson.rest.dto.DepositRequest;
import info.wallyson.rest.dto.TransferRequest;

import java.math.BigDecimal;

public class RequestDataCreator {

  public static Client client() {
    var id = new CPF("97231193072");
    return new Client(id, "Tiringa da silva sauro", BigDecimal.TEN);
  }

  public static ClientRequest clientRequest() {
    return new ClientRequest("225.525.640-11", "Tiringa da silva sauro");
  }

  public static DepositRequest deposit() {
    return new DepositRequest("225.525.640-11", BigDecimal.TEN);
  }

  public static TransferRequest transfer() {
    return new TransferRequest("225.525.640-11", "97231193072", BigDecimal.ONE);
  }
}
