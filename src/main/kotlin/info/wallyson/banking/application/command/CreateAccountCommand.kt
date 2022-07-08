package info.wallyson.banking.application.command


import info.wallyson.banking.domain.account.Client

data class CreateAccountCommand(val client: Client)
