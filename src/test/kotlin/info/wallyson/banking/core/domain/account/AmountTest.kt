package info.wallyson.banking.core.domain.account

import info.wallyson.banking.core.domain.transaction.Amount
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.Exception

internal class AmountTest {

    @Test
    fun `should fail to create amount with zeroed value`() {
        assertThrows<Exception> { Amount(0) }
    }

    @ParameterizedTest
    @ValueSource(longs = [1, -1, 2000, -9876])
    fun `should create amount with positive and negative longs`(value: Long) {
        Amount(value = value)
    }



}