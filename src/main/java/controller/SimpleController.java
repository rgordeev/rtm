package controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import command.CommandFactory;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */
//@WebServlet("*.do")
@Singleton
public class SimpleController extends HttpServlet
{
    @Inject
    CommandFactory commandFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = StringUtils.substringBefore(StringUtils.substringAfterLast(req.getRequestURI(), "/"), ".do");
        String view   = commandFactory.createCommand(action).execute(req);

        req.getRequestDispatcher(view).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String action = StringUtils.substringBefore(StringUtils.substringAfterLast(req.getRequestURI(), "/"), ".do");
        String view   = commandFactory.createCommand(action).execute(req);

        req.getRequestDispatcher(view).forward(req, resp);
    }
}
