package config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import command.CommandFactory;
import command.CommandFactoryImpl;
import storage.DBStorage;
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
        // Описываем сопоставление интерфейсов конкретным классам.
        // При этом указываем Guice, чтобы он создавал единственные экземпляры этих объектов в контексте
        // запущенного приложения.
        //bind(StorageService.class).to(InMemoryStorage.class).in(Singleton.class);
        bind(StorageService.class).to(DBStorage.class).in(Singleton.class);
        bind(CommandFactory.class).to(CommandFactoryImpl.class).in(Singleton.class);
    }
}
