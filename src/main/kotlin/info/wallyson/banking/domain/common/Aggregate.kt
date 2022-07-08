package info.wallyson.banking.domain.common

import org.springframework.data.domain.AbstractAggregateRoot

abstract class Aggregate : AbstractAggregateRoot<Aggregate>() {
    abstract val id: AggregateId

    fun <T : Aggregate> T.addEvent(function: (T) -> AggregateEvent): T =
        this.apply { this.registerEvent(function(this)) }

    fun registeredEvents(): Set<AggregateEvent> = this.domainEvents().map { it as AggregateEvent }.toSet()
}
