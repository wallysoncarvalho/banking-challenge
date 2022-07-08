package info.wallyson.banking.domain.transaction

import java.time.Instant

class P2P(


    val debit: TransactionId,

    val credit: TransactionId,

    val amount: Amount,

    val status: P2PStatus,

    val createdAt: Instant
) {
    enum class P2PStatus { PENDING, COMPLETED }

}
