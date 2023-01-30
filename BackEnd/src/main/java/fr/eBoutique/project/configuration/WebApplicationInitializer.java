package fr.eboutique.project.configuration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfiguration.class);

        servletContext.addListener(new ContextLoaderListener(rootContext));


        DelegatingFilterProxy filterProxy=new DelegatingFilterProxy("springSecurityFilterChain");
        DispatcherServlet dispatcherServlet=new DispatcherServlet(rootContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic registration=servletContext.addServlet("dispatcherServlet",dispatcherServlet);
        servletContext.addFilter("springSecurityFilterChain",filterProxy).addMappingForServletNames(null,false,"/*");
        registration.addMapping("/");

    }
}
