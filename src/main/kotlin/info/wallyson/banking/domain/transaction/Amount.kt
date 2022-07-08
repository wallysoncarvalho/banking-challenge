package info.wallyson.banking.domain.transaction

import java.lang.Exception
import java.math.BigDecimal

data class Amount(val value: Long) {

    init {
        if (value == 0L) throw Exception()
    }

    constructor(value: String) : this(value.toLong())

    constructor(value: BigDecimal) : this(value.toString())
}
