package com.hileco.boot.enabler;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Utility class for making implementing interfaces and presenting the implementations to Spring's {@link org.springframework.beans.factory.support.BeanDefinitionRegistry} easier.
 *
 * Combining this class with the @Enable* style Spring Boot annotations allow you to generate implementations for interfaces using your own sources, much like how spring-data functions.
 *
 * @author Philipp Gayret
 */
public abstract class AbstractInterfaceRegistrar extends InterfaceScanner implements ImportBeanDefinitionRegistrar {

    @SafeVarargs
    public AbstractInterfaceRegistrar(Class<? extends Annotation>... includeFilterAnnotations) {
        for (Class<? extends Annotation> includeFilterAnnotation : includeFilterAnnotations) {
            this.addIncludeFilter(new AnnotationTypeFilter(includeFilterAnnotation, false, true));
        }
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (registry instanceof ConfigurableListableBeanFactory) {
            String basePackage = this.basePackage(importingClassMetadata);
            List<Class<?>> matches = this.getMatches(basePackage);
            ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) registry;
            for (Class<?> match : matches) {
                java.lang.Object instantiated = this.instantiateForRegister(importingClassMetadata, match);
                beanFactory.registerResolvableDependency(match, instantiated);
            }
        }
    }

    /**
     * @param importingClassMetadata additional configuration to abide to
     * @return the base package from which to scan for interfaces with any annotations given at the constructor
     */
    public abstract String basePackage(AnnotationMetadata importingClassMetadata);

    /**
     * Instantiates a bean to be registered as a resolvable dependency on spring's {@link ConfigurableListableBeanFactory}.
     *
     * @param importingClassMetadata additional configuration to abide to
     * @param interfaceClass bean interface definition
     * @return an implementation
     */
    public abstract Object instantiateForRegister(AnnotationMetadata importingClassMetadata, Class<?> interfaceClass);

}
