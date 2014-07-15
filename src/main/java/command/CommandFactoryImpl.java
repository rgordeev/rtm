package command;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import storage.StorageService;

import java.util.HashMap;
import java.util.Map;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
@Singleton
public class CommandFactoryImpl implements CommandFactory
{
    @Inject
    public CommandFactoryImpl(StorageService storage)
    {
        //storage = InMemoryStorage.getInstance();

        this.storage = storage;

        commands = new HashMap<String, Command>();
        commands.put("list",    new ListCommand(this.storage));
        commands.put("add",     new AddCommand(this.storage));
        commands.put("delete",  new DeleteCommand(this.storage));
        commands.put("update",  new UpdateCommand(this.storage));
    }

    @Override
    public Command createCommand(String commandName)
    {
        return commands.get(commandName);
    }


    private Map<String, Command> commands;
    private StorageService storage;
}
