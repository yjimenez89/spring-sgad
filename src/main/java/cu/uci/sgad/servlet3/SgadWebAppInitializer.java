package cu.uci.sgad.servlet3;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cu.uci.sgad.config.RootConfig;
import cu.uci.sgad.config.WebConfig;


public class SgadWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    /**
     * Specify configuration class
     * @return Clases de configuracion especificas para la aplicacion Web
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * Map DispatcherServlet to "/"
     * @return Un conjunto de Map para DispatcherServlet
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
