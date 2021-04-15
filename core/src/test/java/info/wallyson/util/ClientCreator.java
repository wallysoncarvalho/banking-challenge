package info.wallyson.util;

import info.wallyson.domain.CPF;
import info.wallyson.domain.Client;

import java.math.BigDecimal;

public class ClientCreator {

  public static Client single() {
    var id = new CPF("55028292000");
    return new Client(id, "Wally test", BigDecimal.TEN);
  }
}
