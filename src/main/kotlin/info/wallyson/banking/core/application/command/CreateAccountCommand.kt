package info.wallyson.banking.core.application.command

import info.wallyson.banking.core.domain.account.Client

data class CreateAccountCommand(val client: Client)