package info.wallyson.banking

import info.wallyson.banking.core.domain.account.Account
import info.wallyson.banking.core.domain.account.AccountNumber
import info.wallyson.banking.core.domain.account.Client
import info.wallyson.banking.core.domain.common.AggregateId
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.Instant
import java.util.UUID

@SpringBootTest
class AppTests {

    @Test
    fun contextLoads() {

        val acc = Account(
            id = AggregateId(),
            accountNumber = AccountNumber(),
            client = Client(UUID.randomUUID()),
            createdAt = Instant.now()
        )



    }

}
