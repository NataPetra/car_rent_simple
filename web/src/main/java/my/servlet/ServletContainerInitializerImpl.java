package my.servlet;

import my.config.RootConfig;
import my.rest.RestConfig;
import my.service.ServiceContextConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

@Component
public class ServletContainerInitializerImpl implements ServletContainerInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ServletContainerInitializerImpl.class);

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        logger.info("Start ServletContainerInitializer");
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(RootConfig.class);
        context.register(RestConfig.class);
        context.register(ServiceContextConfig.class);

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(context);

        final ServletRegistration.Dynamic servletRegistration =
                ctx.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/index.html");
        servletRegistration.addMapping("/report");
        servletRegistration.addMapping("*.html");
        servletRegistration.addMapping("*.action");
        servletRegistration.addMapping("*.view");
        servletRegistration.addMapping("*.jpg");

    }
}
