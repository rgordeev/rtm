package storage;

import model.Record;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.Collection;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public class InMemoryStorage implements StorageService
{
    private static final StorageService instance = new InMemoryStorage();

    public static StorageService getInstance()
    {
        return instance;
    }

    public InMemoryStorage() {
        this.storage = new ArrayList<Record>();
    }

    @Override
    public Record get(final Long id) {

        Record result = CollectionUtils.find(storage, new Predicate<Record>() {
            @Override
            public boolean evaluate(Record object) {
                return id == object.getId();
            }
        });

        return result == null ? new Record() : result;
    }

    @Override
    public Collection<Record> list() {
        return storage;
    }

    @Override
    public Record add(Record record)
    {
        storage.add(record);
        return record;
    }

    @Override
    public Record update(final Record record)
    {
        Record byID = CollectionUtils.find(storage, new Predicate<Record>() {
            @Override
            public boolean evaluate(Record object) {
                return record.getId() == object.getId();
            }
        });
        byID.setNote(record.getNote());

        return byID;
    }

    @Override
    public void delete(final Record record)
    {
        Collection<Record> delete = CollectionUtils.select(storage, new Predicate<Record>() {
            @Override
            public boolean evaluate(Record object) {
                return record.getId() == object.getId();
            }
        });

        storage = CollectionUtils.removeAll(storage, delete);
    }

    private Collection<Record> storage;
}
