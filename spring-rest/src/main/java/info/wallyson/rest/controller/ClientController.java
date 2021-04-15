package info.wallyson.rest.controller;

import info.wallyson.rest.dto.ClientRequest;
import info.wallyson.rest.dto.DepositRequest;
import info.wallyson.rest.dto.TransferRequest;
import info.wallyson.usecases.Deposit;
import info.wallyson.usecases.RegisterClient;
import info.wallyson.usecases.Transfer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
  private final RegisterClient registerClient;
  private final Transfer transfer;
  private final Deposit deposit;

  public ClientController(RegisterClient registerClient, Transfer transfer, Deposit deposit) {
    this.registerClient = registerClient;
    this.transfer = transfer;
    this.deposit = deposit;
  }

  @PostMapping
  public ResponseEntity<?> registerClient(@Valid @RequestBody ClientRequest clientRequest) {
    var client = clientRequest.toClient();
    registerClient.create(client);
    return ResponseEntity.created(getResourceURI(clientRequest.getCpf())).build();
  }

  private URI getResourceURI(String id) {
    return ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(id)
        .toUri();
  }

  @PostMapping("deposit")
  public ResponseEntity<?> deposit(@Valid @RequestBody final DepositRequest depositRequest) {

    deposit.deposit(depositRequest.getClientId(), depositRequest.getValue());

    return ResponseEntity.ok().build();
  }

  @PostMapping("transfer")
  public ResponseEntity<?> transfer(@Valid @RequestBody TransferRequest transferRequest) {

    transfer.transfer(transferRequest.toTransferData());

    return ResponseEntity.ok().build();
  }
}
