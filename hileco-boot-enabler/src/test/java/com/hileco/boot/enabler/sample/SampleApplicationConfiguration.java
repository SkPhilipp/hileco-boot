package com.hileco.boot.enabler.sample;

import com.hileco.boot.enabler.sample.lib.annotations.EnableMocking;
import org.springframework.context.annotation.Configuration;

/**
 * A basic configuration that only marks itself as being a {@link org.springframework.context.annotation.Configuration} and it makes use of our
 * custom {@link com.hileco.boot.enabler.sample.lib.annotations.EnableMocking} which spring will pick up and eventually process through our custom
 * {@link com.hileco.boot.enabler.sample.lib.MockRegistrar}.
 */
@Configuration
@EnableMocking("com.hileco.boot.enabler.sample.services")
public class SampleApplicationConfiguration {

}
