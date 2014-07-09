package controller;

import com.google.gson.Gson;
import model.Record;
import org.apache.commons.lang3.StringUtils;
import storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * (c) Roman Gordeev
 * <p/>
 * 2014 июл 09
 */

@WebServlet("/rest/*")
public class RestController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        String id = StringUtils.substringAfterLast(req.getPathInfo(), "/");

        PrintWriter out = resp.getWriter();

        if (StringUtils.isEmpty(id))
        {
            out.print(new Gson().toJson(InMemoryStorage.getInstance().list()));
        }
        else
        {
            Long ID = Long.parseLong(id);
            out.print(new Gson().toJson(InMemoryStorage.getInstance().get(ID)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));

        String json = reader.readLine();

        Record record = new Gson().fromJson(json, Record.class);

        InMemoryStorage.getInstance().add(record);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(record));

    }
}
