package command;

import storage.InMemoryStorage;
import storage.StorageService;

import java.util.HashMap;
import java.util.Map;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public class CommandFactory
{
    private static final CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance()
    {
        return instance;
    }

    public CommandFactory()
    {
        storage = InMemoryStorage.getInstance();

        commands.put("list", new ListCommand(storage));
        commands.put("add",  new AddCommand(storage));
    }

    public Command createCommand(String commandName)
    {
        return commands.get(commandName);
    }


    private Map<String, Command> commands = new HashMap<String, Command>();
    private StorageService storage;
}
