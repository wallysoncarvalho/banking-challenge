package info.wallyson.banking.core.domain.common

interface AggregateEvent {
    val aggregateId: String
    val type: String
    val data: String
}