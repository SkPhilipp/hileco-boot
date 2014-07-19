package com.hileco.boot.enabler;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows scanning for interfaces using {@link org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider}'s utilities.
 *
 * @author Philipp Gayret
 */
public class InterfaceScanner extends ClassPathScanningCandidateComponentProvider {

    public InterfaceScanner() {
        super(false);
    }

    public final List<Class<?>> getMatches(String basePackage) {
        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        List<Class<?>> matches = new ArrayList<>();
        for (BeanDefinition candidate : findCandidateComponents(basePackage)) {
            Class resolved = ClassUtils.resolveClassName(candidate.getBeanClassName(), classLoader);
            matches.add(resolved);
        }
        return matches;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

}