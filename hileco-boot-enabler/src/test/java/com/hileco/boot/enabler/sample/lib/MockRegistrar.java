package com.hileco.boot.enabler.sample.lib;

import com.hileco.boot.enabler.AbstractInterfaceRegistrar;
import com.hileco.boot.enabler.sample.lib.annotations.EnableMocking;
import com.hileco.boot.enabler.sample.lib.annotations.Mocked;
import org.mockito.Mockito;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * Scans for interfaces with a {@link com.hileco.boot.enabler.sample.lib.annotations.Mocked} annotation, and registers mocks of those.
 *
 * @author Philipp Gayret
 */
public class MockRegistrar extends AbstractInterfaceRegistrar {

    public MockRegistrar() {
        super(Mocked.class);
    }

    @Override
    public String basePackage(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableMocking.class.getName());
        return (String) annotationAttributes.get("value");
    }

    @Override
    public Object instantiateForRegister(AnnotationMetadata importingClassMetadata, Class<?> interfaceClass) {
        return Mockito.mock(interfaceClass);
    }

}
