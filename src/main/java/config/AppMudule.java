package config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import command.CommandFactory;
import command.CommandFactoryImpl;
import storage.InMemoryStorage;
import storage.StorageService;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 16:46
 */
public class AppMudule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(StorageService.class).to(InMemoryStorage.class).in(Singleton.class);
        bind(CommandFactory.class).to(CommandFactoryImpl.class).in(Singleton.class);
    }
}
