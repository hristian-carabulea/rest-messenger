package com.clearlydecoded.commander;

/**
 * {@link CommandHandler} interface defines methods which allow its implementations to do the actual
 * work of processing a concrete type of {@link Command} implementation and produce a response that
 * is a concerete implementation of {@link CommandResponse}.
 * <p>
 * Clients of this framework should implement a concrete implementation of this interface for each
 * distinct type of {@link Command}/{@link CommandResponse} pair.
 * </p>
 * <p>
 * <b>Warning! Implementations of this interface must account for the fact that the
 * execution of its code might happen in a multi-threaded environment. Do NOT assume that
 * a new instance of this handler will be created for each thread. In other words,
 * multiple threads might share the same instance of the handler.
 * </b>
 * </p>
 */
public interface CommandHandler
    <CommandT extends Command<CommandResponseT>, CommandResponseT extends CommandResponse> {

  /**
   * Executes the <code>command</code>, producing command response of class type which is embedded
   * in the type of <code>command</code>.
   *
   * @param command Command object containing data which is needed for execution this command.
   * @return Command response object that represents a processed response to the
   * <code>command</code>.
   * @throws CommandHandlerException If anything goes wrong during the execution of the command.
   */
  CommandResponseT execute(CommandT command) throws CommandHandlerException;

  /**
   * Retrieves type that this handler is able to process.
   *
   * @return Concrete class type that implements {@link Command} interface.
   */
  Class<CommandT> getCompatibleCommandType();
}
