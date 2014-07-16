package command;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 17:26
 */

/**
 * Интерфейс фабрики команд. Используется для внедрения зависимостей
 * на осонове фабрик или при помощи Guice в контроллеры, реализующие выбор действий на
 * основе анализа строки запроса, например {@link controller.SimpleController}
 *
 * {@link controller.RestController} использует другой механизм при работе с хранилищем и не нуждается
 * в паттерне Команда {@link http://en.wikipedia.org/wiki/Command_pattern} и, как следсвие, в фабрике команд.
 */
public interface CommandFactory
{
    Command createCommand(String commandName);
}
