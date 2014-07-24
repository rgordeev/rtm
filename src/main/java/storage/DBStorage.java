package storage;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;
import model.Record;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * User: rgordeev
 * Date: 22.07.14
 * Time: 11:10
 */
@Singleton
public class DBStorage implements StorageService
{
    @Inject
    public DBStorage(Provider<EntityManager> provider)
    {
        this.provider = provider;
    }

    @Override
    @Transactional
    public Record get(Long id)
    {
        EntityManager manager = provider.get();
        return manager.find(Record.class, id);
    }

    @Override
    @Transactional
    public Collection<Record> list()
    {
        EntityManager manager = provider.get();
        return manager.createQuery("from model.Record").getResultList();
    }

    @Override
    @Transactional
    public Record add(Record record)
    {
        EntityManager manager = provider.get();
        Record newInstance = new Record();
        newInstance.setNote(record.getNote());

        manager.persist(newInstance);
        return newInstance;
    }

    @Override
    @Transactional
    public Record update(Record record)
    {
        EntityManager manager = provider.get();
        return manager.merge(record);
    }

    @Override
    @Transactional
    public void delete(Record record)
    {
        EntityManager manager = provider.get();
        manager.remove(record);
    }

    private Provider<EntityManager> provider;
}
