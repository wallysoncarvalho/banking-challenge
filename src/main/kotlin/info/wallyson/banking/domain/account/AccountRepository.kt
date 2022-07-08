package info.wallyson.banking.domain.account

import info.wallyson.banking.domain.common.AggregateRepository

interface AccountRepository : AggregateRepository<Account> {
    fun findByAccountNumber(number: AccountNumber): Account?
}
