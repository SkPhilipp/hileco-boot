package com.hileco.boot.enabler.sample.lib.annotations;

import com.hileco.boot.enabler.sample.lib.MockRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Annotation to enable interface mocking. Will scan the package of the annotated configuration class for {@link com.hileco.boot.enabler.sample.lib.annotations.Mocked} interfaces.
 *
 * @author Philipp Gayret
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(MockRegistrar.class)
public @interface EnableMocking {

    /**
     * @return base package from where to scan for interfaces
     */
    public String value();

}
