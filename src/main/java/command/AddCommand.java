package command;

import model.Record;
import org.apache.commons.lang3.StringUtils;
import storage.StorageService;

import javax.servlet.http.HttpServletRequest;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public class AddCommand implements Command
{
    public AddCommand(StorageService storage)
    {
        this.storage = storage;
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        if (StringUtils.equalsIgnoreCase("get", request.getMethod()))
            return "/view/add.jsp";

        String id = request.getParameter("id");
        String note = request.getParameter("note");

        Record record = new Record(Long.parseLong(id), note);
        storage.add(record);

        return "list.do";
    }

    private StorageService storage;
}
