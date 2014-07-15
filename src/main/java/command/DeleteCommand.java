package command;

import model.Record;
import storage.StorageService;

import javax.servlet.http.HttpServletRequest;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 12:24
 */
public class DeleteCommand extends AbstractCommand
{
    public DeleteCommand(StorageService storage)
    {
        super(storage);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        String id     = request.getParameter("id");
        Record delete = storage.get(Long.parseLong(id));

        storage.delete(delete);

        return "/list.do";
    }
}
