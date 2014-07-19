package com.hileco.boot.enabler.sample.lib.annotations;

import java.lang.annotation.*;

/**
 * Marks an interface for mocking via {@link com.hileco.boot.enabler.sample.lib.MockRegistrar}.
 *
 * @author Philipp Gayret
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mocked {
}
