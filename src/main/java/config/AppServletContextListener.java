package config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import controller.RestController;
import controller.SimpleController;

/**
 * User: rgordeev
 * Date: 14.07.14
 * Time: 17:01
 */
public class AppServletContextListener extends GuiceServletContextListener
{
    @Override
    protected Injector getInjector()
    {
        // регистрируем Singleton-сервлет SimpleController
        // на все URI вида *.do
        // аннотация @WebServlet("*.do") сервлету более не нужна
        return Guice.createInjector(
                new ServletModule()
                {
                    @Override
                    protected void configureServlets()
                    {
                        serve("*.do").with(SimpleController.class);
                        serve("/rest/*").with(RestController.class);
                    }
                },
                new AppMudule());
    }
}
