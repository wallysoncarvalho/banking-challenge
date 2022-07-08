package info.wallyson.banking.domain.account

import info.wallyson.banking.application.command.CreateAccountCommand
import info.wallyson.banking.domain.common.AggregateId
import java.time.Instant

object AccountFactory {

    fun from(command: CreateAccountCommand) = Account(
        id = AggregateId(),
        number = AccountNumber(),
        client = command.client,
        createdAt = Instant.now(),
        status = AccountStatus.ACTIVE
    )
}
