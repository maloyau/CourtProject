package com.serhii.court;

import com.serhii.court.configs.DataConfig;
import com.serhii.court.configs.MvcConfig;
import com.serhii.court.configs.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{DataConfig.class, SecurityConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
