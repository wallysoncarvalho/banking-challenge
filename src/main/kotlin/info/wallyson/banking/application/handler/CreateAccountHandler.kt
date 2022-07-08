package info.wallyson.banking.application.handler

import info.wallyson.banking.application.command.CreateAccountCommand
import info.wallyson.banking.domain.account.Account
import info.wallyson.banking.domain.account.AccountFactory
import info.wallyson.banking.domain.account.AccountRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class CreateAccountHandler(
    private val repository: AccountRepository
): ICommandHandler<CreateAccountCommand> {

    override fun execute(command: CreateAccountCommand) {
        val account = AccountFactory.from(command)
        repository.insert(account)
    }
}
