package info.wallyson.banking.core.application.command

interface ICommandHandler<T> {
    fun execute(command: T)
}
