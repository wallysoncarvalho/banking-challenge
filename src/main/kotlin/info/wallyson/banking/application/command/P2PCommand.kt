package info.wallyson.banking.application.command

import info.wallyson.banking.domain.account.Client
import info.wallyson.banking.domain.transaction.Amount

data class P2PCommand(val debit: Client, val credit: Client, val amount: Amount)
