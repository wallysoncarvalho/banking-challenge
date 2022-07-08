package info.wallyson.banking.domain.common

interface AggregateRepository<T> {
    fun insert(aggregate: T): T
    fun update(aggregate: T): T
}
