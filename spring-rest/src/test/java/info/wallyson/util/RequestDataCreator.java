package info.wallyson.util;

import info.wallyson.rest.dto.ClientRequest;
import info.wallyson.rest.dto.DepositRequest;
import info.wallyson.rest.dto.TransferRequest;

import java.math.BigDecimal;

public class RequestDataCreator {

  public static ClientRequest client() {
    return new ClientRequest("225.525.640-11", "Tiringa da silva sauro");
  }

  public static DepositRequest deposit() {
    return new DepositRequest("225.525.640-11", BigDecimal.TEN);
  }

  public static TransferRequest transfer() {
    return new TransferRequest("225.525.640-11", "97231193072", BigDecimal.ONE);
  }
}
