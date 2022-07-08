package info.wallyson.banking.adapter.jdbc

import info.wallyson.banking.domain.account.Account
import info.wallyson.banking.domain.account.AccountNumber
import info.wallyson.banking.domain.account.AccountRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.jdbc.core.JdbcAggregateTemplate
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JDBCAccountRepository(
    private val jdbcTemplate: JdbcTemplate,
    private val jdbcAggregateTemplate: JdbcAggregateTemplate,
    private val eventPublisher: ApplicationEventPublisher
) : AccountRepository, JDBCAggregateRepository<Account>(jdbcAggregateTemplate, eventPublisher) {

    override fun findByAccountNumber(number: AccountNumber): Account? {

        return jdbcTemplate.queryForObject(
            "select * from account ac where ac.number = ${number.number}",
            Account::class.java
        )

    }
}
