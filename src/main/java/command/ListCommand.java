package command;

import storage.StorageService;

import javax.servlet.http.HttpServletRequest;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public class ListCommand extends AbstractCommand
{
    public ListCommand(StorageService storage)
    {
        super(storage);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        request.setAttribute("storage", storage);
        return "/view/list.jsp";
    }
}
