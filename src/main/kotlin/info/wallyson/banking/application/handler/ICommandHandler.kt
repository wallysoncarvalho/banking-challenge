package info.wallyson.banking.application.handler

interface ICommandHandler<T> {
    fun execute(command: T)
}
