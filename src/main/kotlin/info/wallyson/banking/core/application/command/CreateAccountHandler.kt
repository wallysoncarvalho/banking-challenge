package info.wallyson.banking.core.application.command

import info.wallyson.banking.core.domain.account.Account
import info.wallyson.banking.core.domain.account.AccountRepository
import java.time.Instant

class CreateAccountHandler(
    private val accountRepository: AccountRepository
): ICommandHandler<CreateAccountCommand> {

    override fun execute(command: CreateAccountCommand) {

        val account = Account(client = command.client, createdAt = Instant.now())

        accountRepository.insert(account)


    }


}