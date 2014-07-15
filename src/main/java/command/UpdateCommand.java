package command;

import model.Record;
import storage.StorageService;

import javax.servlet.http.HttpServletRequest;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 12:43
 */
public class UpdateCommand extends AbstractCommand
{
    public UpdateCommand(StorageService storage)
    {
        super(storage);
    }

    @Override
    public String execute(HttpServletRequest request)
    {
        // в случае, если пришел GET запрос
        if ("get".equalsIgnoreCase(request.getMethod()))
        {
            // получаем идентификатор обновляемой записи
            String id       = request.getParameter("id");
            // получаем запись из хранилища по идентификатору
            Record record   = storage.get(Long.parseLong(id));
            // полученную запись добавляем в атрибуты запроса
            request.setAttribute("record", record);
            // передаем запрос диспетчеру для перенаправления на update.jsp
            return "/view/update.jsp";
        }
        // для POST запроса
        // получаем идентификатор обновляемой записи
        String id       = request.getParameter("id");
        // получаем новое значение атрибута Record.note
        String note     = request.getParameter("note");
        // получаем запись из хранилища по идентификатору
        Record record   = storage.get(Long.parseLong(id));
        // обновляем значение атрибута note записи
        record.setNote(note);
        // обноляем хранилище
        storage.update(record);
        // передаем диспетчеру запрос на отображение списка записей
        // с пердварительной инициализацией бина storage на странице list.jsp
        // посредством выполнения действия ListCommand
        return "/list.do";

    }
}
