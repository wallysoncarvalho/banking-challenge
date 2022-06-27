package info.wallyson.banking.core.domain.transaction

import info.wallyson.banking.core.domain.account.Client
import java.util.UUID

class Transaction(

    val transactionId: TransactionId,

    val amount: Amount,

    val client: Client,

    val type: TransactionType,


    // @Id
    val surrogateId: UUID? = null,
) {

}
