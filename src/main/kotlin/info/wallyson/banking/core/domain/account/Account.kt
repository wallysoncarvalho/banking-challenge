package info.wallyson.banking.core.domain.account

import info.wallyson.banking.core.domain.common.Aggregate
import info.wallyson.banking.core.domain.common.AggregateId
import org.springframework.data.domain.AbstractAggregateRoot
import java.time.Instant

class Account(
    override val id: AggregateId,

    val accountNumber: AccountNumber = AccountNumber(),

    val client: Client,



    val createdAt: Instant,


    // surrogate identity
): Aggregate() {


}
