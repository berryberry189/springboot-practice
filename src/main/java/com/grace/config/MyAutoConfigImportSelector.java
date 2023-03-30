package com.grace.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyAutoConfigImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
                "com.grace.config.autoconfig.DispatcherServletConfig",
                "com.grace.config.autoconfig.TomcatWebServerConfig"
        };
    }
}
