package info.wallyson.banking.domain.account

import info.wallyson.banking.domain.common.Aggregate
import info.wallyson.banking.domain.common.AggregateId
import java.time.Instant

class Account(
    override val id: AggregateId,
    val number: AccountNumber = AccountNumber(),
    val client: Client,
    val status: AccountStatus,
    val createdAt: Instant
): Aggregate() {








}
