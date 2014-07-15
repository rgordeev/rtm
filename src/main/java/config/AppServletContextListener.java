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

        params.put(JERSEY_CONFIG_PROPERTY_PACKAGES, SERVER_RESOURCES_PACKAGE);
        params.put(JERSEY_API_JSON_POJO_MAPPING_FEATURE, "true");

        // регистрируем Singleton-сервлет SimpleController
        // на все URI вида *.do
        // аннотация @WebServlet("*.do") сервлету более не нужна
        return Guice.createInjector(
                new ServletModule()
                {
                    @Override
                    protected void configureServlets()
                    {
                        serve("*.do")   .with(SimpleController.class        );
                        serve("/rst/*") .with(RestController.class          );
                        serve("/rest/*").with(GuiceContainer.class, params  );
                    }
                },
                new AppMudule());
    }
}
