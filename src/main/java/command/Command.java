package command;

import javax.servlet.http.HttpServletRequest;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
public interface Command
{
    String execute(HttpServletRequest request);
}
