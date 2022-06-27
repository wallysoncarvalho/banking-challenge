package info.wallyson.banking.core.domain.common

import java.time.Instant

open class AggregateEvent(
    open val id: EventId,
    open val type: EventType,
    open val aggregateId: AggregateId,
    open val occuredOn: Instant = Instant.now()
)
