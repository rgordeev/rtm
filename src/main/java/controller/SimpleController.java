package controller;

import command.CommandFactory;
import org.apache.commons.lang3.StringUtils;
import storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
@WebServlet("*.do")
public class SimpleController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = StringUtils.substringBetween(req.getServletPath(), "/", ".do");
        String view   = CommandFactory.getInstance().createCommand(action).execute(req);

        req.getRequestDispatcher(view).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = StringUtils.substringBetween(req.getServletPath(), "/", ".do");
        String view   = CommandFactory.getInstance().createCommand(action).execute(req);

        req.getRequestDispatcher(view).forward(req, resp);
    }
}
