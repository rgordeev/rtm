package config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import controller.RestController;
import controller.SimpleController;

import java.util.HashMap;
import java.util.Map;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 17:01
 */

/**
 * Класс реализует интерфейс {@see javax.servlet.ServletContextListener} и таким образом
 * участвует в событийной модели контейнера сервлетов, а именно реагирует на создание контекста
 * приложения в момент его загрузки в контейнер сервлетов и его уничтожение в момент выгрузки приложения.
 *
 * Все что делает {@link com.google.inject.servlet.GuiceServletContextListener} - добавляет в контекст сервлетов
 * атрибут, содержащий ссылку на объект инжектор {@link com.google.inject.Injector}, который замем используется
 * фильтром {@link com.google.inject.servlet.GuiceFilter} для внедрения зависимостей в сеорвлеты.
 * Данный фильтр необходимо отобразить на множество url адресов, которые обратываются сервлетами, имеющими
 * зависимости. В нашем приложении мы отобразили этот фильтр на все множество url адресов нашего приложения,
 * добавив в web.xml запись
 *
 * <filter>
 *   <filter-name>guiceFilter</filter-name>
 *   <filter-class>com.google.inject.servlet.GuiceFilter</filter-class>
 * </filter>
 *
 * <filter-mapping>
 *   <filter-name>guiceFilter</filter-name>
 *   <url-pattern>/*</url-pattern>
 * </filter-mapping>
 *
 */
public class AppServletContextListener extends GuiceServletContextListener
{
    private static final String SERVER_RESOURCES_PACKAGE                = "rest";
    private static final String JERSEY_API_JSON_POJO_MAPPING_FEATURE    = "com.sun.jersey.api.json.POJOMappingFeature";
    private static final String JERSEY_CONFIG_PROPERTY_PACKAGES         = "com.sun.jersey.config.property.packages";


    @Override
    protected Injector getInjector()
    {
        // инициализируем параметры, которые Guice передаст в параметры инициализации сервлета Jersey
        final Map<String, String> params = new HashMap<String, String>();

        params.put(JERSEY_CONFIG_PROPERTY_PACKAGES, SERVER_RESOURCES_PACKAGE); // <-- указываем какие пакеты приложения обрабатывать в процессе поиска rest сервисов Jersey (в нашем случае это единственный пакет rest, содержащий класс rest.RESTService)
        params.put(JERSEY_API_JSON_POJO_MAPPING_FEATURE, "true"); // <-- используем JSON маршаллер/демаршаллер для POJO объектов {@see https://jersey.java.net/documentation/1.18/json.html}

        /**
         Отображаем Singleton-сервлет SimpleController на все URI вида *.do аннотация @WebServlet("*.do") сервлету более не нужна.
         Сервлет controller.RestController отображаем на url вида /rst/*

         И кроме того регистрируем специальный сервлет библиотеки Jersey для внедрения зависимостей в rest-сервисы, созданные на основе Jersey.
         */
        return Guice.createInjector(
                new ServletModule() // <-- инициализируем модуль для отображения сервлетов
                {
                    @Override
                    protected void configureServlets()
                    {
                        serve("*.do")   .with(SimpleController.class        );
                        serve("/rst/*") .with(RestController.class          );
                        serve("/rest/*").with(GuiceContainer.class, params  );
                    }
                },
                new AppMudule() // <-- наш основной модуль сопоставления интерфейсов
        );
    }
}
