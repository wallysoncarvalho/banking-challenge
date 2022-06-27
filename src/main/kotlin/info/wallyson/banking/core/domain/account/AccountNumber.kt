package info.wallyson.banking.core.domain.account

import kotlin.random.Random

data class AccountNumber(val number: Int = generate()) {

    companion object {
        fun generate() = Random.nextInt(1000000, Int.MAX_VALUE)
    }
}
