package info.wallyson.banking.adapter.jdbc

import info.wallyson.banking.domain.common.Aggregate
import info.wallyson.banking.domain.common.AggregateRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.jdbc.core.JdbcAggregateTemplate
import org.springframework.stereotype.Repository

open class JDBCAggregateRepository<T : Aggregate>(
    private val jdbcAggregateTemplate: JdbcAggregateTemplate,
    private val eventPublisher: ApplicationEventPublisher
) : AggregateRepository<T> {

    override fun insert(aggregate: T): T {
        val savedAggregate = jdbcAggregateTemplate.insert(aggregate)

        aggregate.registeredEvents().onEach { eventPublisher.publishEvent(it) }

        return savedAggregate
    }

    override fun update(aggregate: T): T {
        val events = aggregate.registeredEvents()

        if (events.isEmpty()) return aggregate

        events.onEach { eventPublisher.publishEvent(it) }

        return jdbcAggregateTemplate.update(aggregate)
    }
}
