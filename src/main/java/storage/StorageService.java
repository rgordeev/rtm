package storage;

import model.Record;

import java.util.Collection;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public interface StorageService
{
    Record get(Long id);

    Collection<Record> list();

    Record add(Record record);

    Record update(Record record);

    void delete(Record record);

}
