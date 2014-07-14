package command;

import storage.StorageService;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 13:02
 */
public abstract class AbstractCommand implements Command
{
    protected StorageService storage;

    public AbstractCommand(StorageService storage)
    {
        this.storage = storage;
    }
}
