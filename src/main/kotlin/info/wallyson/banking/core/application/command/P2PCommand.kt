package info.wallyson.banking.core.application.command

import info.wallyson.banking.core.domain.transaction.Amount
import info.wallyson.banking.core.domain.account.Client

data class P2PCommand(val debit: Client, val credit: Client, val amount: Amount)
