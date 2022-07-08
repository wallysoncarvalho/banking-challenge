package info.wallyson.banking.domain.transaction

import info.wallyson.banking.domain.account.Client
import java.util.UUID

class Transaction(

    val transactionId: TransactionId,

    val amount: Amount,

    val client: Client




) {

}
