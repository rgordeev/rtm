package command;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 17:26
 */
public interface CommandFactory
{
    Command createCommand(String commandName);
}
