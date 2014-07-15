package rest;

import com.google.inject.Inject;
import model.Record;
import storage.StorageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * User: rgordeev
 * Date: 15.07.14
 * Time: 15:41
 */
@Path("/record")
@Produces(MediaType.APPLICATION_JSON)
public class RESTService
{
    StorageService storage;

    @Inject
    public RESTService(StorageService storage)
    {
        this.storage = storage;
    }

    @GET
    public Collection<Record> list()
    {
        return storage.list();
    }

    @Path("{id}")
    @GET
    public Record user(@PathParam("id") Long id)
    {
        return storage.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Record create(Record record) {
        return storage.add(record);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Record update(Record user) {
        return storage.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") Long id)
    {
        Record record = storage.get(id);
        storage.delete(record);
    }
}
