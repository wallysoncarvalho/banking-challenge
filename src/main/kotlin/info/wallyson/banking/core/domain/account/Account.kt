package info.wallyson.banking.core.domain.account

import org.springframework.data.domain.AbstractAggregateRoot
import java.time.Instant

class Account(


    val accountNumber: AccountNumber = AccountNumber(),

    val client: Client,



    val createdAt: Instant


    // surrogate identity
): AbstractAggregateRoot<Account>() {


}
